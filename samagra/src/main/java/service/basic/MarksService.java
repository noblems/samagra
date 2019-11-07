package service.basic;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import entity.MarksDAO;
import mappers.MarksMapper;

public class MarksService {
	public MarksDAO insertMarks(MarksDAO marksDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			MarksMapper marksMapper = sqlSession.getMapper(MarksMapper.class);
			marksDao.setCreatedDate(new Date(0));
			marksDao.setActiveInd(1);
			marksMapper.insertMarks(marksDao);
			sqlSession.commit();
			return marksDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	
	public MarksDAO getMarksById(Integer marksId) throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  MarksMapper marksMapper = sqlSession.getMapper(MarksMapper.class);
		  MarksDAO marksDao=marksMapper.getMarksById(marksId);
		  sqlSession.commit();
		  return marksDao;
		  }catch(Exception e) {
				sqlSession.rollback();
				e.printStackTrace();
				throw e;
		}finally{
		   sqlSession.close();
		  }
		 }
	
	public List<MarksDAO> getAllMarks() throws Exception {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	
		try{
			
			MarksMapper marksMapper = sqlSession.getMapper(MarksMapper.class);
			
			return marksMapper.getAllMarks();
			

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
			
		}
	}
	public MarksDAO updateMarks(int marksId,MarksDAO marksDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			MarksMapper marksMapper = sqlSession.getMapper(MarksMapper.class);
			marksDao.setUpdatedDate(new Date(0));
			marksMapper.updateMarks(marksDao);
			sqlSession.commit();
			return marksDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}

	public MarksDAO deleteMarks(Integer marksId) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			MarksMapper marksMapper = sqlSession.getMapper(MarksMapper.class);
			MarksDAO marksDao=new MarksDAO();//marksMapper.getMarksById(marksId);
			//System.out.println("fetched marksid"+marksDao.getMarksId());
			//marksDao.setUpdatedDate(new Date(0));
			marksMapper.deleteMarks(marksId);
			
			sqlSession.commit();
			return marksDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	/*public MarksDAO extractMarksFromStudentDto(Student student)throws Exception {
		MarksDAO marksDao=new MarksDAO();
		//marksDao.setMarksId(studentDao.getStudentMarksId());
		marksDao.setFirstName(student.getFirstName());
		marksDao.setMiddleName(student.getMiddleName());
		marksDao.setLastName(student.getLastName());
		marksDao.setDob(student.getDob());
		marksDao.setSex(student.getSex());
		return marksDao;
	}*/
	/*public static void main(String[] args) {
		//MarksDAO marksDao= new MarksDAO();
		//System.out.print("begin");
		//marksDao.setMarksType("test2");
		MarksService ss=new MarksService();
		//System.out.print("outer");
		try {
			//ss.insertMarks(marksDao);
			//marksDao=ss.getAllMarks().get(0);
			ss.deleteMarks(10);
			//marksDao=ss.getMarksById(1);
			//marksDao=ss.getMarksById(2);
			//System.out.print("\n\ndone");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
}
