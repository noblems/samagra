package mappers;

import java.util.List;

import entity.StudentDAO;

public interface StudentMapper {
	public void insertStudent(StudentDAO student);
	 
	 public StudentDAO getStudentById(Integer studentId);
	 
	 public List<StudentDAO> getAllStudent();
	 
	 public void updateStudent(StudentDAO student);
	 
	 public void deleteStudent(Integer studentId);
}
