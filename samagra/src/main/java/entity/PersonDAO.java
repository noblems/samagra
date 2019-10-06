package entity;

import java.util.Date;

public class PersonDAO {
	private int personId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String DOB;
	private String sex ;
	private String createdDate; 
	private String updatedDate; 
	private int activeInd; 
	
	
	public void setPersonId(int personId) {
		this.personId=personId;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName=middleName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public void setDOB(String DOB) {
		this.DOB=DOB;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}
	public void setCreatedDate() {
		this.createdDate=new Date().toString();
	}
	public void setUpdatedDate() {
		this.updatedDate=new Date().toString();
	}
	public void setActiveInd(int activeInd) {
		this.activeInd=activeInd;
	}
}

