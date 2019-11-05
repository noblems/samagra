package mappers;

import java.util.List;

import entity.StaffDAO;

public interface StaffMapper {
	public void insertStaff(StaffDAO staff);
	 
	 public StaffDAO getStaffById(Integer staffId);
	 
	 public List<StaffDAO> getAllStaff();
	 
	 public void updateStaff(StaffDAO staff);
	 
	 public void deleteStaff(Integer staffId);
}
