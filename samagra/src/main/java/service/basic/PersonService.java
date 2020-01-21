package service.basic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Staff;
import dto.Student;
import entity.PersonDAO;
import mappers.PersonMapper;

public class PersonService {

	public PersonDAO insertPerson(PersonDAO personDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			personDao.setCreatedDate(new Date(0));
			personDao.setActiveInd(1);
			personMapper.insertPerson(personDao);
			sqlSession.commit();
			return personDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	
	public PersonDAO getPersonById(Integer personId) throws Exception {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
		  PersonDAO personDao=personMapper.getPersonById(personId);
		  sqlSession.commit();
		  return personDao;
		  }catch(Exception e) {
				sqlSession.rollback();
				e.printStackTrace();
				throw e;
		}finally{
		   sqlSession.close();
		  }
		 }
	
	public List<PersonDAO> getAllPerson() throws Exception {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	
		try{
			
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			
			return personMapper.getAllPerson();
			

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
			
		}
	}
	public PersonDAO updatePerson(int personId,PersonDAO personDao) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			personDao.setPersonId(personId);
			personMapper.updatePerson(personDao);
			System.out.println("going to commit person");
			sqlSession.commit();
			return personDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}

	public PersonDAO deletePerson(Integer personId) throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			PersonDAO personDao=personMapper.getPersonById(personId);
			personDao.setUpdatedDate(new Date(0));
			personMapper.deletePerson(personId);
			
			sqlSession.commit();
			return personDao;
		}catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			sqlSession.close();
		}
	}
	public PersonDAO extractPersonFromStudentDto(Student student)throws Exception {
		PersonDAO personDao=new PersonDAO();
		//personDao.setPersonId(studentDao.getStudentPersonId());
		personDao.setFirstName(student.getFirstName());
		personDao.setMiddleName(student.getMiddleName());
		personDao.setLastName(student.getLastName());
		personDao.setDob(student.getDob());
		personDao.setSex(student.getSex());
		return personDao;
	}
	public PersonDAO extractPersonFromStaffDto(Staff staff) {
		PersonDAO personDao=new PersonDAO();
		personDao.setFirstName(staff.getFirstName());
		System.out.println("firist nane"+staff.getFirstName()+"keriyath"+personDao.getFirstName());
		personDao.setMiddleName(staff.getMiddleName());
		personDao.setLastName(staff.getLastName());
		personDao.setDob(staff.getDob());
		personDao.setSex(staff.getSex());
		return personDao;
	}
	
}
