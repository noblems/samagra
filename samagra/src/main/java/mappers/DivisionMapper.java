package mappers;

import java.util.List;

import entity.DivisionDAO;

public interface DivisionMapper {
	public void insertAddress(DivisionDAO division);
	 
	 public DivisionDAO getAddressById(Integer divisionId);
	 
	 public List<DivisionDAO> getAllAddress();
	 
	 public void updateAddress(DivisionDAO division);
	 
	 public void deleteAddress(Integer divisionId);
}
