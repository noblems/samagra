package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.ibatis.session.SqlSession;

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

	/*public PersonDAO getpersonById(Integer personId) {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
		  return personMapper.getPersonById(personId);
		  }finally{
		   sqlSession.close();
		  }
		 }*/
	/*public Student getStudentById(Integer studentId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Student student=new Student();
		try{

			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			student.setStudentId(studentMapper.getStudentById(studentId).getStudentId());
			student.setRegisterNumber(studentMapper.getStudentById(studentId).getRegisterNumber());
			student.setAdmissionNumber(studentMapper.getStudentById(studentId).getAdmissionNumber());
			student.setFirstName(personMapper.getPersonById(studentMapper.getStudentById(studentId).getStudentPersonId()).getLastName());
			student.setMiddleName(personMapper.getPersonById(studentMapper.getStudentById(studentId).getStudentPersonId()).getMiddleName());
			student.setLastName(personMapper.getPersonById(studentMapper.getStudentById(studentId).getStudentPersonId()).getLastName());
			student.setDob(personMapper.getPersonById(studentMapper.getStudentById(studentId).getStudentPersonId()).getDOB());
			student.setSex(personMapper.getPersonById(studentMapper.getStudentById(studentId).getStudentPersonId()).getSex());
			student.setPersonId(personMapper.getPersonById(studentMapper.getStudentById(studentId).getStudentPersonId()).getPersonId());


		}catch(Exception e) {
			System.out.println("error occurred");
			student.setStudentId(-1);
			student.setMessage("No such student available");
		}finally{
			sqlSession.close();
		}
		return student;
	}*/

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
				AddressDAO addressDao=addressService.getAddressById(studentDao.get(i).getStudentAddressId());
				studentService.wrapStudentDto(studentDao.get(i),
						personService.getPersonById(studentDao.get(i).getStudentPersonId()),
						addressService.wrapAddressToAddressDto(addressDao));
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
				studentDao=studentService.updateStudent(studentId, studentDao);
				addressDao=addressService.updateAddress(studentDao.getStudentAddressId(), addressDao);
				personDao=personService.updatePerson(studentDao.getStudentPersonId(), personDao);
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
