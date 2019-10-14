package service;

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

	
	public Student getStudentById(Integer studentId) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Student student=new Student();
		try{
			StudentService studentService=new StudentService();
			PersonService personService= new PersonService();
			AddressService addressService=new AddressService();
			if(studentService.getStudentById(studentId)!=null) {
				StudentDAO studentDao=studentService.getStudentById(studentId);
				AddressDAO addressDao=addressService.getAddressById(studentDao.getStudentAddressId());
				PersonDAO personDao=personService.getPersonById(studentDao.getStudentPersonId());
				//personDao.setPersonId(studentservice);
				Address address=addressService.wrapAddressToAddressDto(addressDao);
				student=studentService.wrapStudentDto(studentDao, personDao, address);
				return student;
			}else {
				throw new NoSuchElementException();
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
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
				//System.out.println("stdao"+studentDao.get(i).getStudentAddressId());
				AddressDAO addressDao=addressService.getAddressById(studentDao.get(i).getStudentAddressId());
				student=studentService.wrapStudentDto(studentDao.get(i),
						personService.getPersonById(studentDao.get(i).getStudentPersonId()),
						addressService.wrapAddressToAddressDto(addressDao));
				//System.out.println("stude"+student.getFirstName());
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
			if(studentService.getStudentById(studentId)!=null) {
				StudentDAO studentDao=studentService.extractStudentFromStudentDto(student);
				AddressDAO addressDao=addressService.extractAddressFromStudentDto(student);
				PersonDAO personDao=personService.extractPersonFromStudentDto(student);
				//personDao.setPersonId(studentservice);
				studentDao=studentService.updateStudent(studentId, studentDao);
				addressDao=addressService.updateAddress(studentService.getStudentById(studentId).getStudentAddressId(), addressDao);
				personDao=personService.updatePerson(studentService.getStudentById(studentId).getStudentPersonId(), personDao);
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
			//System.out.println("my activ ind is"+studentDao.getActiveInd());
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}

}


}
