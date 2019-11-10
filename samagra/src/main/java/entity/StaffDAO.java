package entity;

import java.util.Date;

public class StaffDAO {
	private int staffId;
	private String staffType;
	private int staffPersonId;
	private int addressId;
	private int divisionId;
	private Date createdDate;
	private Date updatedDate;
	private int activeInd;
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public int getStaffPersonId() {
		return staffPersonId;
	}
	public void setStaffPersonId(int staffPersonId) {
		this.staffPersonId = staffPersonId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public int getActiveInd() {
		return activeInd;
	}
	public void setActiveInd(int activeInd) {
		this.activeInd = activeInd;
	}
	public int getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}
}
