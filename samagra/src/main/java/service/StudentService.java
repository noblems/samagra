package service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Student;
import entity.StudentDAO;
import mappers.StudentMapper;
import service.MyBatisUtil;

public class StudentService {

	
	public StudentDAO insertStudent(StudentDAO studentDao) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			studentDao.setCreatedDate(new Date());
			studentDao.setActiveInd(1);
			studentMapper.insertStudent(studentDao);

			sqlSession.commit();
			return studentDao;
		}finally{
			sqlSession.close();
		}
	}
	public StudentDAO getStudentById(Integer studentId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{

			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.getStudentById(studentId);
			
		}catch(Exception e) {
			System.out.println("error occurred");
			StudentDAO studentDaoerror=new StudentDAO();
			studentDaoerror.setStudentId(-1);
			return studentDaoerror;
		}finally{
			sqlSession.close();
		}
	}

	public List<StudentDAO> getAllStudent() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		
			try {
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			return studentMapper.getAllStudent();
		}catch(Exception e) {
			System.out.println("error occurred");
			StudentDAO studenterror=new StudentDAO();
			studenterror.setStudentId(-1);
			return (List<StudentDAO>) studenterror;
		}finally{
			sqlSession.close();
			
		}
	}
	public StudentDAO updateStudent(int studentId,StudentDAO studentDao) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			studentDao.setUpdatedDate(new Date());
			studentMapper.updateStudent(studentDao);

			sqlSession.commit();
			return studentDao;
		}catch(Exception e) {
			sqlSession.rollback();
			System.out.println("error occurred");
			StudentDAO studentDaoerror=new StudentDAO();
			studentDaoerror.setStudentId(-1);
			return studentDaoerror;
		}finally{
			sqlSession.close();
		}
	}

	
	public StudentDAO deleteStudent(Integer studentId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			StudentDAO studentDao=studentMapper.getStudentById(studentId);
			studentMapper.deleteStudent(studentId);
			sqlSession.commit();
			return studentDao;
		}catch(Exception e) {
			sqlSession.rollback();
			System.out.println("error occurred");
			StudentDAO studentDaoerror=new StudentDAO();
			studentDaoerror.setStudentId(-1);
			return studentDaoerror;
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
}
