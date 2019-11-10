package service.basic;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Staff;
import dto.Student;
import entity.PersonDAO;
import entity.StaffDAO;
import mappers.StaffMapper;

public class StaffService {
	public StaffDAO insertStaff(StaffDAO staffDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
			staffDao.setCreatedDate(new Date(0));
			staffDao.setActiveInd(1);
			staffMapper.insertStaff(staffDao);
			sqlSession.commit();
			return staffDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	
	public StaffDAO getStaffById(Integer staffId) throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
		  StaffDAO staffDao=staffMapper.getStaffById(staffId);
		  sqlSession.commit();
		  return staffDao;
		  }catch(Exception e) {
				sqlSession.rollback();
				e.printStackTrace();
				throw e;
		}finally{
		   sqlSession.close();
		  }
		 }
	
	public List<StaffDAO> getAllStaff() throws Exception {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	
		try{
			
			StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
			
			return staffMapper.getAllStaff();
			

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
			
		}
	}
	public StaffDAO updateStaff(int staffId,StaffDAO staffDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
			staffDao.setUpdatedDate(new Date(0));
			staffMapper.updateStaff(staffDao);
			sqlSession.commit();
			return staffDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}

	public StaffDAO deleteStaff(Integer staffId) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
			StaffDAO staffDao=new StaffDAO();//staffMapper.getStaffById(staffId);
			//System.out.println("fetched staffid"+staffDao.getStaffId());
			//staffDao.setUpdatedDate(new Date(0));
			staffMapper.deleteStaff(staffId);
			
			sqlSession.commit();
			return staffDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	public Staff wrapStaffDto(StaffDAO staffDao,PersonDAO personDao) {
		Staff staff=new Staff();
		staff.setStaffId(staffDao.getStaffId());
		staff.setStaffType(staffDao.getStaffType());
		staff.setFirstName(personDao.getFirstName());
		staff.setMiddleName(personDao.getMiddleName());
		staff.setLastName(personDao.getLastName());
		staff.setDob(personDao.getDob());
		staff.setSex(personDao.getSex());
		staff.setDivisionId(staffDao.getDivisionId());
		return staff;
	}

	/*public StaffDAO extractStaffFromStudentDto(Student student)throws Exception {
		StaffDAO staffDao=new StaffDAO();
		//staffDao.setStaffId(studentDao.getStudentStaffId());
		staffDao.setFirstName(student.getFirstName());
		staffDao.setMiddleName(student.getMiddleName());
		staffDao.setLastName(student.getLastName());
		staffDao.setDob(student.getDob());
		staffDao.setSex(student.getSex());
		return staffDao;
	}*/
	/*public static void main(String[] args) {
		//StaffDAO staffDao= new StaffDAO();
		//System.out.print("begin");
		//staffDao.setStaffType("test2");
		StaffService ss=new StaffService();
		//System.out.print("outer");
		try {
			//ss.insertStaff(staffDao);
			//staffDao=ss.getAllStaff().get(0);
			ss.deleteStaff(10);
			//staffDao=ss.getStaffById(1);
			//staffDao=ss.getStaffById(2);
			//System.out.print("\n\ndone");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public StaffDAO extractStaffFromStaffDto(Staff staff) {
		StaffDAO staffDao= new StaffDAO();
		staffDao.setStaffType(staff.getStaffType());
		staffDao.setStaffPersonId(staff.getPersonId());
		staffDao.setAddressId(staff.getAddress().getAddressId());
		staffDao.setDivisionId(staff.getDivisionId());
		return staffDao;
	}
}
