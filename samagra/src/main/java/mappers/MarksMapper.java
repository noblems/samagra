package mappers;

import java.util.List;

import entity.MarksDAO;

public interface MarksMapper {
	public void insertAddress(MarksDAO marks);
	 
	 public MarksDAO getAddressById(Integer marksId);
	 
	 public List<MarksDAO> getAllAddress();
	 
	 public void updateAddress(MarksDAO marks);
	 
	 public void deleteAddress(Integer marksId);
}
