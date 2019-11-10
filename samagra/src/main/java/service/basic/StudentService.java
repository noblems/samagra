package service.basic;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Address;
import dto.Student;
import entity.AddressDAO;
import entity.PersonDAO;
import entity.StudentDAO;
import mappers.StudentMapper;

public class StudentService {

	
	public StudentDAO insertStudent(StudentDAO studentDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			studentDao.setCreatedDate(new Date());
			studentDao.setActiveInd(1);
			studentMapper.insertStudent(studentDao);

			sqlSession.commit();
			return studentDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
		
			sqlSession.close();
		}
	}
	public StudentDAO getStudentById(Integer studentId) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{

			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.getStudentById(studentId);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	
	public StudentDAO getStudentByAdmissionNumber(Integer admissionNumber) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{

			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.getStudentsByAdmissionNumber(admissionNumber);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	
	public StudentDAO getStudentByRegisterNumber(Integer registerNumber) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{

			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.getStudentsByRegisterNumber(registerNumber);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}

	public List<StudentDAO> getAllStudent() throws Exception {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
			try {
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			return studentMapper.getAllStudent();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
			
		}
	}
	
public List<StudentDAO> getAllStudentsByDivision(int divisionId) throws Exception {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
			try {
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			return studentMapper.getStudentsByDivisionId(divisionId);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
			
		}
	}

	public StudentDAO updateStudent(int studentId,StudentDAO studentDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			studentDao.setUpdatedDate(new Date());
			studentMapper.updateStudent(studentDao);

			sqlSession.commit();
			return studentDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}

	
	public StudentDAO deleteStudent(Integer studentId) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			StudentDAO studentDao=studentMapper.getStudentById(studentId);
			studentMapper.deleteStudent(studentId);
			sqlSession.commit();
			return studentDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	public StudentDAO extractStudentFromStudentDto(Student student) {
		StudentDAO studentDao=new StudentDAO();
		//System.out.println(personDao.getPersonId());
		studentDao.setRegisterNumber(student.getRegisterNumber());
		studentDao.setAdmissionNumber(student.getAdmissionNumber());
		studentDao.setDivisionId(student.getDivisionId());
		return studentDao;
	}
	public Student wrapStudentDto(StudentDAO studentDao,PersonDAO personDao,Address address) {
		Student student =  new Student();
		student.setStudentId(studentDao.getStudentId());
		student.setAdmissionNumber(studentDao.getAdmissionNumber());
		student.setRegisterNumber(studentDao.getRegisterNumber());
		student.setFirstName(personDao.getFirstName());
		student.setMiddleName(personDao.getMiddleName());
		student.setLastName(personDao.getLastName());
		student.setPersonId(personDao.getPersonId());
		student.setDob(personDao.getDob());
		student.setSex(personDao.getSex());
		student.setAddress(address);
		student.setDivisionId(studentDao.getDivisionId());
		//System.out.println("i set following"+student.getFirstName());
		return student;
	}
}
