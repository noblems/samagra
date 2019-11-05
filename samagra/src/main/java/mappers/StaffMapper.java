package mappers;

import java.util.List;

import entity.StaffDAO;

public interface StaffMapper {
	public void insertAddress(StaffDAO staff);
	 
	 public StaffDAO getAddressById(Integer staffId);
	 
	 public List<StaffDAO> getAllAddress();
	 
	 public void updateAddress(StaffDAO staff);
	 
	 public void deleteAddress(Integer staffId);
}
