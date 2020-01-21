package service.basic;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import entity.SubjectsDAO;
import mappers.SubjectsMapper;

public class SubjectsService {
	public SubjectsDAO insertSubjects(SubjectsDAO subjectsDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			SubjectsMapper subjectsMapper = sqlSession.getMapper(SubjectsMapper.class);
			subjectsDao.setCreatedDate(new Date(0));
			subjectsDao.setActiveInd(1);
			subjectsMapper.insertSubjects(subjectsDao);
			sqlSession.commit();
			return subjectsDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	
	public SubjectsDAO getSubjectsById(Integer subjectsId) throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  SubjectsMapper subjectsMapper = sqlSession.getMapper(SubjectsMapper.class);
		  SubjectsDAO subjectsDao=subjectsMapper.getSubjectsById(subjectsId);
		  sqlSession.commit();
		  return subjectsDao;
		  }catch(Exception e) {
				sqlSession.rollback();
				e.printStackTrace();
				throw e;
		}finally{
		   sqlSession.close();
		  }
		 }
	
	public List<SubjectsDAO> getAllSubjects() throws Exception {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	
		try{
			
			SubjectsMapper subjectsMapper = sqlSession.getMapper(SubjectsMapper.class);
			
			return subjectsMapper.getAllSubjects();
			

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
			
		}
	}
	public SubjectsDAO updateSubjects(int subjectsId,SubjectsDAO subjectsDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			SubjectsMapper subjectsMapper = sqlSession.getMapper(SubjectsMapper.class);
			subjectsDao.setUpdatedDate(new Date(0));
			subjectsMapper.updateSubjects(subjectsDao);
			sqlSession.commit();
			return subjectsDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}

	public SubjectsDAO deleteSubjects(Integer subjectsId) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			SubjectsMapper subjectsMapper = sqlSession.getMapper(SubjectsMapper.class);
			SubjectsDAO subjectsDao=new SubjectsDAO();//subjectsMapper.getSubjectsById(subjectsId);
			//System.out.println("fetched subjectsid"+subjectsDao.getSubjectsId());
			//subjectsDao.setUpdatedDate(new Date(0));
			subjectsMapper.deleteSubjects(subjectsId);
			
			sqlSession.commit();
			return subjectsDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	/*public SubjectsDAO extractSubjectsFromStudentDto(Student student)throws Exception {
		SubjectsDAO subjectsDao=new SubjectsDAO();
		//subjectsDao.setSubjectsId(studentDao.getStudentSubjectsId());
		subjectsDao.setFirstName(student.getFirstName());
		subjectsDao.setMiddleName(student.getMiddleName());
		subjectsDao.setLastName(student.getLastName());
		subjectsDao.setDob(student.getDob());
		subjectsDao.setSex(student.getSex());
		return subjectsDao;
	}*/
	public static void main(String[] args) {
		SubjectsDAO subjectsDao= new SubjectsDAO();
		//System.out.print("begin");
		subjectsDao.setSubjectName("test2");
		SubjectsService ss=new SubjectsService();
		//System.out.print("outer");
		try {
			ss.insertSubjects(subjectsDao);
			subjectsDao=ss.getAllSubjects().get(0);
			//ss.deleteSubjects(10);
			//subjectsDao=ss.getSubjectsById(1);
			//subjectsDao=ss.getSubjectsById(2);
			System.out.print(subjectsDao.getSubjectName()+"\n\ndone");
			subjectsDao=ss.getSubjectsById(1);
			System.out.print("by id"+subjectsDao.getSubjectName()+"\n\ndone");
			subjectsDao.setSubjectName("unit test");
			ss.updateSubjects(1, subjectsDao);
			subjectsDao=ss.getSubjectsById(1);
			System.out.print("by id after update"+subjectsDao.getSubjectName()+"\n\ndone");
			ss.deleteSubjects(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
