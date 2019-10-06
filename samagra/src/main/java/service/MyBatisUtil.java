package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	 
	 private MyBatisUtil() {
	 
	 
	 
	 }
	 
	 
	 public static SqlSessionFactory getSqlSessionFactory() 
	 {
		 Reader reader = null;
		  try {
		   reader = Resources.getResourceAsReader("mybatis-config.xml");
		  } catch (IOException e) {
		   throw new RuntimeException(e.getMessage());
		  }
		  factory = new SqlSessionFactoryBuilder().build(reader);
		  //factory.getConfiguration().addMapper(UsersMappers.class);
		  return factory;
	 }
}
