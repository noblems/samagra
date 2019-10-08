package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Student;
import entity.PersonDAO;
import mappers.PersonMapper;

public class PersonService {

	public PersonDAO insertPerson(PersonDAO personDao) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			personDao.setCreatedDate(new Date());
			personDao.setActiveInd(1);
			personMapper.insertPerson(personDao);
			sqlSession.commit();
			return personDao;
		}catch(Exception e) {
			sqlSession.rollback();
			PersonDAO personDaoerror=new PersonDAO();
			personDaoerror.setPersonId(-1);
			return personDaoerror;
		}finally{
			sqlSession.close();
		}
	}
	
	public PersonDAO getpersonById(Integer personId) {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
		  PersonDAO personDao=personMapper.getPersonById(personId);
		  sqlSession.commit();
		  return personDao;
		  }catch(Exception e) {
				sqlSession.rollback();
				PersonDAO personDaoerror=new PersonDAO();
				personDaoerror.setPersonId(-1);
				return personDaoerror;
		}finally{
		   sqlSession.close();
		  }
		 }
	
	public List<PersonDAO> getAllPerson() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
	
		try{
			
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			
			return personMapper.getAllPerson();
			

		}catch(Exception e) {
			System.out.println("error occurred");
			PersonDAO personerror=new PersonDAO();
			personerror.setPersonId(-1);
			return (List<PersonDAO>) personerror;
		}finally{
			sqlSession.close();
			
		}
	}
	public PersonDAO updatePerson(int personId,PersonDAO personDao) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			personDao.setUpdatedDate(new Date());
			personMapper.updatePerson(personDao);
			sqlSession.commit();
			return personDao;
		}catch(Exception e) {
			sqlSession.rollback();
			PersonDAO personDaoerror=new PersonDAO();
			personDaoerror.setPersonId(-1);
			return personDaoerror;
		}finally{
			sqlSession.close();
		}
	}

	public PersonDAO deletePerson(Integer personId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			PersonDAO personDao=personMapper.getPersonById(personId);
			personDao.setUpdatedDate(new Date());
			personMapper.deletePerson(personId);
			
			sqlSession.commit();
			return personDao;
		}catch(Exception e) {
			sqlSession.rollback();
			PersonDAO personDaoerror=new PersonDAO();
			personDaoerror.setPersonId(-1);
			return personDaoerror;
		}finally{
			sqlSession.close();
		}
	}
	public PersonDAO extractPersonFromStudentDto(Student student) {
		PersonDAO personDao=new PersonDAO();
		//personDao.setPersonId(studentDao.getStudentPersonId());
		personDao.setFirstName(student.getFirstName());
		personDao.setMiddleName(student.getMiddleName());
		personDao.setLastName(student.getLastName());
		personDao.setDob(new Date().toString());
		/*try {
			
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date dob=df.parse(student.getDob());
			System.out.println("my unformated is"+student.getDob()+"my formatted dob is"+dob);
			personDao.setDob(new Date());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		personDao.setSex(student.getSex());
		return personDao;
	}
	
}
