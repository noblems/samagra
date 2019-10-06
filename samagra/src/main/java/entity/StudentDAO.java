package entity;

public class StudentDAO {
	private int studentId;
	private int studentPersonId;
	private int registerNumber;
	private int admissionNumber; 
	private int studentAddressID;
	private String createdDate;
	private String updatedDate;
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
	public int getStudentAddressID() {
		return studentAddressID;
	}
	public void setStudentAddressID(int studentAddressID) {
		this.studentAddressID = studentAddressID;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public int getActiveInd() {
		return activeInd;
	}
	public void setActiveInd(int activeInd) {
		this.activeInd = activeInd;
	}
}
