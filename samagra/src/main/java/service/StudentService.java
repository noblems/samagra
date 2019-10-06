package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import entity.StudentDAO;
import mappers.StudentMapper;
import service.MyBatisUtil;

public class StudentService {
	
	/*public void insertPerson(PersonDAO person) {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
		  personMapper.insertPerson(person);
		  sqlSession.commit();
		  }finally{
		   sqlSession.close();
		  }
		 }
		 
		 public PersonDAO getpersonById(Integer personId) {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  try{
		  PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
		  return personMapper.getPersonById(personId);
		  }finally{
		   sqlSession.close();
		  }
		 }
		 */
		 public String getAllStudent() {
		  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		  String students="hello\n";
		  try{
			  //PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
			  StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			  List<StudentDAO> studentDao=studentMapper.getAllStudent();
			  
			  //Iterator studentIterator =  studentDao.iterator();
			  for(int i=0;i<studentDao.size();i++){
				  students.concat(Integer.toString(studentDao.get(i).getStudentId()));
				  students.concat("\n");
				  students.concat(studentDao.get(i).getCreatedDate());
				  students.concat("\n");
				  /*Student studentDto=new Student();
				  PersonDAO personDao=personMapper.getPersonById(studentDao.get(i).getStudentPersonId());
				  studentDto.setStudentId(100);//studentDao.get(i).getStudentId());
				  students.add(studentDto);*/
			  }
			  return students;
			  
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
}
