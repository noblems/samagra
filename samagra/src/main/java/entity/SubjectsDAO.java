package entity;

import java.util.Date;

public class SubjectsDAO {
	private int subjectsId;
	private String subjectName;
	private int staffId;
	private Date createdDate;
	private Date updatedDate;
	private int activeInd;
	public int getSubjectsId() {
		return subjectsId;
	}
	public void setSubjectsId(int subjectsId) {
		this.subjectsId = subjectsId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
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