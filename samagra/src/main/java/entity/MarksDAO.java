package entity;

import java.util.Date;

public class MarksDAO {
	private int markId;
	private int subjectId;
	private int studentId;
	private float mark;
	private String grade;
	private Date createdDate;
	private Date updatedDate;
	private int activeInd;
	public int getMarkId() {
		return markId;
	}
	public void setMarkId(int markId) {
		this.markId = markId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
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