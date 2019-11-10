package service.functionalities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.ibatis.session.SqlSession;

import dto.Address;
import dto.Student;
import entity.AddressDAO;
import entity.PersonDAO;
import entity.StudentDAO;
import exceptions.StudentFunctionServiceException;
import mappers.AddressMapper;
import mappers.PersonMapper;
import mappers.StudentMapper;
import service.basic.AddressService;
import service.basic.MyBatisUtil;
import service.basic.PersonService;
import service.basic.StudentService;

public class StudentFunctionsService {

	public void insertStudent(Student student) throws  Exception {
		try {
			StudentService studentService=new StudentService();
			PersonService personService= new PersonService();
			AddressService addressService=new AddressService();
			PersonDAO personDao=personService.extractPersonFromStudentDto(student);
			personDao=personService.insertPerson(personDao);
			AddressDAO addressDao=addressService.extractAddressFromStudentDto(student);
			//System.out.println("person id="+personDao.getPersonId());
			addressDao.setAddressPersonId(personDao.getPersonId());
			addressDao=addressService.insertAddress(addressDao);
			StudentDAO studentDao=studentService.extractStudentFromStudentDto(student);
			studentDao.setStudentPersonId(personDao.getPersonId());
			studentDao.setStudentAddressId(addressDao.getAddressId());
			studentDao=studentService.insertStudent(studentDao);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/*public PersonDAO getpersonById(Integer personId) {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
		  return personMapper.getPersonById(personId);
		  }finally{
		   sqlSession.close();
		  }
		 }*/
	public Student getStudentById(Integer studentId) {
		Student student=new Student();
		try{

			PersonService personService = new PersonService();
			StudentService studentService = new StudentService();
			AddressService addressService = new AddressService();
			StudentDAO studentDao=studentService.getStudentById(studentId);
			PersonDAO personDao=personService.getPersonById(studentDao.getStudentPersonId());
			AddressDAO addressDao=addressService.getAddressById(studentDao.getStudentAddressId());
			Address address=addressService.wrapAddressToAddressDto(addressDao);
			student.setStudentId(studentDao.getStudentId());
			student.setRegisterNumber(studentDao.getRegisterNumber());
			student.setAdmissionNumber(studentDao.getAdmissionNumber());
			student.setFirstName(personDao.getLastName());
			student.setMiddleName(personDao.getMiddleName());
			student.setLastName(personDao.getLastName());
			student.setDob(personDao.getDob());
			student.setSex(personDao.getSex());
			student.setPersonId(studentDao.getStudentPersonId());
			student.setAddress(address);
			student.setDivisionId(studentDao.getDivisionId());


		}catch(Exception e) {
			System.out.println("error occurred");
			student.setStudentId(-1);
			student.setMessage("No such student available");
		}
		return student;
	}

	public List<Student> getAllStudent() throws Exception {

		List<Student>students = new ArrayList<Student>();
		StudentService studentService=new StudentService();
		PersonService personService= new PersonService();
		AddressService addressService=new AddressService();
		try{
			List<StudentDAO> studentDao=studentService.getAllStudent();
			//System.out.println(studentDao.size());
			//Iterator studentIterator =  studentDao.iterator();
			for(int i=0;i<studentDao.size();i++){
				Student student=new Student();
				System.out.println("stdao"+studentDao.get(i).getStudentAddressId());
				AddressDAO addressDao=addressService.getAddressById(studentDao.get(i).getStudentAddressId());
				student=studentService.wrapStudentDto(studentDao.get(i),
						personService.getPersonById(studentDao.get(i).getStudentPersonId()),
						addressService.wrapAddressToAddressDto(addressDao));
				System.out.println("stude"+student.getFirstName());
				students.add(student);
			}


		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return students;
	}
	public void updateStudent(int studentId,Student student) throws Exception {
		try{
			StudentService studentService=new StudentService();
			PersonService personService= new PersonService();
			AddressService addressService=new AddressService();
			StudentDAO studentDaoexisting=studentService.getStudentById(studentId);
			if(studentDaoexisting!=null) {
				StudentDAO studentDao=studentService.extractStudentFromStudentDto(student);
				studentDao.setStudentAddressId(studentDaoexisting.getStudentAddressId());
				studentDao.setDivisionId(studentDaoexisting.getDivisionId());
				studentDao.setStudentPersonId(studentDaoexisting.getStudentPersonId());
				AddressDAO addressDao=addressService.extractAddressFromStudentDto(student);
				PersonDAO personDao=personService.extractPersonFromStudentDto(student);
				//personDao.setPersonId(studentservice);
				studentDao=studentService.updateStudent(studentId, studentDao);
				System.out.println("in functionalities"+studentDao.getStudentId());
				addressDao=addressService.updateAddress(studentDaoexisting.getStudentAddressId(), addressDao);
				personDao=personService.updatePerson(studentDaoexisting.getStudentPersonId(), personDao);
			}else {
				throw new NoSuchElementException();
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	public void deleteStudent(Integer studentId) throws Exception {
		try {
			StudentService studentService=new StudentService();
			PersonService personService= new PersonService();
			AddressService addressService=new AddressService();
			StudentDAO studentDao=studentService.getStudentById(studentId);
			AddressDAO addressDao=addressService.deleteAddress(studentDao.getStudentAddressId());
			PersonDAO personDao=personService.deletePerson(studentDao.getStudentPersonId());
			studentDao=studentService.deleteStudent(studentId);
			System.out.println("my activ ind is"+studentDao.getActiveInd());
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}

	}


}
