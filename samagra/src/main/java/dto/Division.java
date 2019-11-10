package dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Division")
public class Division {
	@JacksonXmlProperty(isAttribute = true)
	private int divisionId;
	@JacksonXmlProperty
	private String divisionName;
	@JacksonXmlProperty
	private Staff  staff;
	@JacksonXmlProperty
	private String divisionDescription;
	@JacksonXmlProperty
	private int standard;
	@JacksonXmlProperty
	List<Student> students;
	public int getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getDivisionDescription() {
		return divisionDescription;
	}
	public void setDivisionDescription(String divisionDescription) {
		this.divisionDescription = divisionDescription;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
