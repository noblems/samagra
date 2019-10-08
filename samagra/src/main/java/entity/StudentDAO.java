package entity;

import java.util.Date;

public class StudentDAO {
	private int studentId;
	private int studentPersonId;
	private int registerNumber;
	private int admissionNumber; 
	private int studentAddressId;
	private Date createdDate;
	private Date updatedDate;
	private int activeInd;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getStudentPersonId() {
		return studentPersonId;
	}
	public void setStudentPersonId(int studentPersonId) {
		this.studentPersonId = studentPersonId;
	}
	public int getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(int registerNumber) {
		this.registerNumber = registerNumber;
	}
	public int getAdmissionNumber() {
		return admissionNumber;
	}
	public void setAdmissionNumber(int admissionNumber) {
		this.admissionNumber = admissionNumber;
	}
	public int getStudentAddressId() {
		return studentAddressId;
	}
	public void setStudentAddressId(int studentAddressId) {
		this.studentAddressId = studentAddressId;
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
}
