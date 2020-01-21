package mappers;

import java.util.List;

import entity.MarksDAO;

public interface MarksMapper {
	public void insertMarks(MarksDAO marks);
	 
	 public MarksDAO getMarksById(Integer marksId);
	 
	 public List<MarksDAO> getAllMarks();
	 
	 public void updateMarks(MarksDAO marks);
	 
	 public void deleteMarks(Integer marksId);
}
