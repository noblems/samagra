package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Student;
import entity.PersonDAO;
import entity.StudentDAO;
import mappers.PersonMapper;
import mappers.StudentMapper;
import service.MyBatisUtil;

public class StudentService {

	private List<Student> students;

	public void insertPerson(PersonDAO person) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			personMapper.insertPerson(person);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}
	public void insertStudent(Student student) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			PersonDAO personDao=new PersonDAO();
			StudentDAO studentDao=new StudentDAO();
			personDao.setFirstName(student.getFirstName());
			personDao.setMiddleName(student.getMiddleName());
			personDao.setLastName(student.getLastName());
			personDao.setDOB(student.getDOB());
			personDao.setSex(student.getSex());
			personDao.setCreatedDate(new Date().toString());
			personDao.setUpdatedDate(new Date().toString());
			personDao.setActiveInd(1);
			personMapper.insertPerson(personDao);


			//System.out.println(personDao.getPersonId());
			studentDao.setStudentPersonId(personDao.getPersonId());
			studentDao.setRegisterNumber(student.getRegisterNumber());
			studentDao.setAdmissionNumber(student.getAdmissionNumber());
			studentDao.setStudentAddressId(1);
			studentDao.setCreatedDate(new Date().toString());
			studentDao.setUpdatedDate(new Date().toString());
			studentDao.setActiveInd(1);
			studentMapper.insertStudent(studentDao);

			sqlSession.commit();
		}finally{
			sqlSession.close();
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
			student.setDOB(personMapper.getPersonById(studentMapper.getStudentById(studentId).getStudentPersonId()).getDOB());
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
			List<StudentDAO> studentDao=studentMapper.getAllStudent();
			System.out.println(studentDao.size());
			//Iterator studentIterator =  studentDao.iterator();
			for(int i=0;i<studentDao.size();i++){
				Student student=new Student();
				student.setStudentId(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentId());
				student.setRegisterNumber(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getRegisterNumber());
				student.setAdmissionNumber(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getAdmissionNumber());
				//System.out.println("here");
				student.setFirstName(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getFirstName());
				student.setMiddleName(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getMiddleName());
				student.setLastName(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getLastName());
				student.setDOB(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getDOB());
				student.setSex(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getSex());
				student.setPersonId(personMapper.getPersonById(studentMapper.getStudentById(studentDao.get(i).getStudentId()).getStudentPersonId()).getPersonId());
				//student.setMessage("helo");
				students.add(student);
				//System.out.println("here too");
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
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			StudentDAO studentDao=studentMapper.getStudentById(studentId);
			PersonDAO personDao=personMapper.getPersonById(studentDao.getStudentPersonId());
			//personDao.setPersonId(studentDao.getStudentPersonId());
			personDao.setFirstName(student.getFirstName());
			personDao.setMiddleName(student.getMiddleName());
			personDao.setLastName(student.getLastName());
			personDao.setDOB(student.getDOB());
			personDao.setSex(student.getSex());
			personDao.setUpdatedDate(new Date().toString());
			
			studentDao.setAdmissionNumber(student.getAdmissionNumber());
			studentDao.setRegisterNumber(student.getRegisterNumber());
			studentDao.setUpdatedDate(new Date().toString());
			personMapper.updatePerson(personDao);
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

	/* public void updateperson(PersonDAO person) {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
		  personMapper.updatePerson(person);
		  sqlSession.commit();
		  }finally{
		   sqlSession.close();
		  }

		 }

		 public void deleteperson(Integer personId) {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
		  personMapper.deletePerson(personId);
		  sqlSession.commit();
		  }finally{
		   sqlSession.close();
		  }

		 }*/
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
}
