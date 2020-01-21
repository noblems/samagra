package mappers;

import java.util.List;

import entity.DivisionDAO;

public interface DivisionMapper {
	public void insertDivision(DivisionDAO division);
	 
	 public DivisionDAO getDivisionById(Integer divisionId);
	 
	 public List<DivisionDAO> getAllDivision();
	 
	 public void updateDivision(DivisionDAO division);
	 
	 public void deleteDivision(Integer divisionId);
}
