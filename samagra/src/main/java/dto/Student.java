package dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Student")
public class Student {
	@JacksonXmlProperty(isAttribute = true)
	private int studentId;
	@JacksonXmlProperty
	private int registerNumber;
	@JacksonXmlProperty
	private int admissionNumber;
	@JacksonXmlProperty
	private String firstName;
	@JacksonXmlProperty
	private String middleName;
	@JacksonXmlProperty
	private String lastName;
	@JacksonXmlProperty
	private String dob;
	@JacksonXmlProperty
	private String sex;
	@JacksonXmlProperty
	private int personId;
	@JacksonXmlProperty
	private String message="OK";
	@JacksonXmlProperty
	private Address address=new Address();
	@JacksonXmlProperty
	private List<Marks> marks;
	@JacksonXmlProperty
	private int divisionId;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	public int getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}
}
