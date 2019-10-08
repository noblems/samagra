package service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Address;
import dto.Student;
import entity.AddressDAO;
import entity.PersonDAO;
import entity.StudentDAO;
import mappers.StudentMapper;
import service.MyBatisUtil;

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
		return studentDao;
	}
	public Student wrapStudentDto(StudentDAO studentDao,PersonDAO personDao,Address address) {
		Student student =  new Student();
		student.setAdmissionNumber(studentDao.getAdmissionNumber());
		student.setRegisterNumber(studentDao.getRegisterNumber());
		student.setFirstName(personDao.getFirstName());
		student.setMiddleName(personDao.getMiddleName());
		student.setLastName(personDao.getLastName());
		student.setDob(personDao.getDob());
		student.setAddress(address);
		return student;
	}
}
