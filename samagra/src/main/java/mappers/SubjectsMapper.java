package mappers;

import java.util.List;

import entity.SubjectsDAO;

public interface SubjectsMapper {
	public void insertSubjects(SubjectsDAO subjects);
	 
	 public SubjectsDAO getSubjectsById(Integer subjectsId);
	 
	 public List<SubjectsDAO> getAllSubjects();
	 
	 public void updateSubjects(SubjectsDAO subjects);
	 
	 public void deleteSubjects(Integer subjectsId);
}
