package service.basic;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import entity.DivisionDAO;
import mappers.DivisionMapper;

public class DivisionService {
	public DivisionDAO insertDivision(DivisionDAO divisionDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			DivisionMapper divisionMapper = sqlSession.getMapper(DivisionMapper.class);
			divisionDao.setCreatedDate(new Date(0));
			divisionDao.setActiveInd(1);
			divisionMapper.insertDivision(divisionDao);
			sqlSession.commit();
			return divisionDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	
	public DivisionDAO getDivisionById(Integer divisionId) throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  DivisionMapper divisionMapper = sqlSession.getMapper(DivisionMapper.class);
		  DivisionDAO divisionDao=divisionMapper.getDivisionById(divisionId);
		  sqlSession.commit();
		  return divisionDao;
		  }catch(Exception e) {
				sqlSession.rollback();
				e.printStackTrace();
				throw e;
		}finally{
		   sqlSession.close();
		  }
		 }
	
	public List<DivisionDAO> getAllDivision() throws Exception {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	
		try{
			
			DivisionMapper divisionMapper = sqlSession.getMapper(DivisionMapper.class);
			
			return divisionMapper.getAllDivision();
			

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
			
		}
	}
	public DivisionDAO updateDivision(int divisionId,DivisionDAO divisionDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			DivisionMapper divisionMapper = sqlSession.getMapper(DivisionMapper.class);
			divisionDao.setUpdatedDate(new Date(0));
			divisionMapper.updateDivision(divisionDao);
			sqlSession.commit();
			return divisionDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}

	public DivisionDAO deleteDivision(Integer divisionId) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			DivisionMapper divisionMapper = sqlSession.getMapper(DivisionMapper.class);
			DivisionDAO divisionDao=new DivisionDAO();//divisionMapper.getDivisionById(divisionId);
			//System.out.println("fetched divisionid"+divisionDao.getDivisionId());
			//divisionDao.setUpdatedDate(new Date(0));
			divisionMapper.deleteDivision(divisionId);
			
			sqlSession.commit();
			return divisionDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	/*public DivisionDAO extractDivisionFromStudentDto(Student student)throws Exception {
		DivisionDAO divisionDao=new DivisionDAO();
		//divisionDao.setDivisionId(studentDao.getStudentDivisionId());
		divisionDao.setFirstName(student.getFirstName());
		divisionDao.setMiddleName(student.getMiddleName());
		divisionDao.setLastName(student.getLastName());
		divisionDao.setDob(student.getDob());
		divisionDao.setSex(student.getSex());
		return divisionDao;
	}*/
	/*public static void main(String[] args) {
		//DivisionDAO divisionDao= new DivisionDAO();
		//System.out.print("begin");
		//divisionDao.setDivisionType("test2");
		DivisionService ss=new DivisionService();
		//System.out.print("outer");
		try {
			//ss.insertDivision(divisionDao);
			//divisionDao=ss.getAllDivision().get(0);
			ss.deleteDivision(10);
			//divisionDao=ss.getDivisionById(1);
			//divisionDao=ss.getDivisionById(2);
			//System.out.print("\n\ndone");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
}
