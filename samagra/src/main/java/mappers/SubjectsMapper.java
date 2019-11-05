package mappers;

import java.util.List;

import entity.SubjectsDAO;

public interface SubjectsMapper {
	public void insertStudent(SubjectsDAO subjects);
	 
	 public SubjectsDAO getStudentById(Integer subjectsId);
	 
	 public List<SubjectsDAO> getAllStudent();
	 
	 public void updateStudent(SubjectsDAO subjects);
	 
	 public void deleteStudent(Integer subjectsId);
}
