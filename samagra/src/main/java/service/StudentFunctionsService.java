package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Student;
import entity.AddressDAO;
import entity.PersonDAO;
import entity.StudentDAO;
import exceptions.StudentFunctionServiceException;

public class StudentFunctionsService {

	public void insertStudent(Student student) throws  StudentFunctionServiceException {
		StudentService studentService=new StudentService();
		PersonService personService= new PersonService();
		AddressService addressService=new AddressService();
		PersonDAO personDao=personService.extractPersonFromStudentDto(student);
		personDao=personService.insertPerson(personDao);
		if(personDao.getPersonId()!=-1) {
			AddressDAO addressDao=addressService.extractAddressFromStudentDto(student);
			System.out.println("person id="+personDao.getPersonId());
			addressDao.setAddressPersonId(personDao.getPersonId());
			addressDao=addressService.insertAddress(addressDao);
			if(addressDao.getAddressId()!=-1) {
				StudentDAO studentDao=studentService.extractStudentFromStudentDto(student);
				studentDao.setStudentPersonId(personDao.getPersonId());
				studentDao.setStudentAddressId(addressDao.getAddressId());
				studentDao=studentService.insertStudent(studentDao);
				if(studentDao.getStudentId()==-1) {
					StudentFunctionServiceException e=new StudentFunctionServiceException();
					e.setStudentDao(studentDao.getStudentId());
					e.setMessage("something went wrong with insertion of student");
					throw e;
				}
			}else{
				StudentFunctionServiceException e=new StudentFunctionServiceException();
				e.setAddressDao(addressDao.getAddressId());
				e.setMessage("something went wrong with insertion of addresss");
				throw e;
			}
		}else{
			StudentFunctionServiceException e=new StudentFunctionServiceException();
			e.setPersonDao(personDao.getPersonId());
			e.setMessage("something went wrong with insertion of person");
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
	}

	public List<Student> getAllStudent() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Student>students = new ArrayList<Student>();
		try{

			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
			List<StudentDAO> studentDao=studentMapper.getAllStudent();
			System.out.println(studentDao.size());
			//Iterator studentIterator =  studentDao.iterator();
			for(int i=0;i<studentDao.size();i++){
				Student student=new Student();
				student.setStudentId(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentId());
				student.setRegisterNumber(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getRegisterNumber());
				student.setAdmissionNumber(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getAdmissionNumber());
				System.out.println("here");
				student.setFirstName(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getFirstName());
				student.setMiddleName(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getMiddleName());
				student.setLastName(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getLastName());
				student.setDob(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getDOB());
				student.setSex(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getSex());
				student.setPersonId(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getPersonId());
				System.out.println("here too ffh");
				AddressDAO addressDao=addressMapper.getAddressById(studentDao.get(i).getStudentAddressId());
				Address address=new Address();
				address.setAddr1(addressDao.getAddr1());
				address.setAddr2(addressDao.getAddr2());
				address.setAddr3(addressDao.getAddr3());
				address.setCity(addressDao.getCity());
				address.setState(addressDao.getState());
				address.setPin(addressDao.getPin());
				student.setAddress(address);
				//student.setMessage("helo");
				students.add(student);
				System.out.println("here too");
			}


		}catch(Exception e) {
			System.out.println("error occurred");
			Student studenterror=new Student();
			studenterror.setStudentId(-1);
			studenterror.setMessage("No students are available");
			students.add(studenterror);
		}finally{
			sqlSession.close();

		}
		return students;
	}
	public String updateStudent(int studentId,Student student) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			PersonService personService = new PersonService();
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			StudentDAO studentDao=studentMapper.getStudentById(studentId);
			int personId=studentDao.getStudentPersonId();
			PersonDAO personDao=personService.updatePerson(personId,personService.extractPersonFromStudentDto(student));
			studentDao.setAdmissionNumber(student.getAdmissionNumber());
			studentDao.setRegisterNumber(student.getRegisterNumber());
			studentDao.setUpdatedDate(new Date().toString());
			studentMapper.updateStudent(studentDao);

			sqlSession.commit();
			return "Updated Successfully";
		}catch(Exception e) {
			sqlSession.rollback();
			return "Some error happened check later "+e.getMessage();
		}finally{
			sqlSession.close();
		}
	}


	public String deleteStudent(Integer StudentId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			personMapper.deletePerson(studentMapper.getStudentById(StudentId).getStudentPersonId());
			studentMapper.deleteStudent(StudentId);

			sqlSession.commit();
			return "Updated Successfully";
		}catch(Exception e) {
			sqlSession.rollback();
			return "Some error happened check later "+e.getMessage();
		}finally{
			sqlSession.close();
		}
	}

}*/


}
