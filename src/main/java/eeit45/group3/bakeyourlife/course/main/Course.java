package eeit45.group3.bakeyourlife.course.main;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Course")
public class Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer openCourse;
	
	private String courseID;
	@JsonFormat(timezone = "GMT+8")
	private Date startDate;
	@JsonFormat(timezone = "GMT+8")
	private Date endDate;
	private String room;
	private Integer registerMax;
	private String teacher;
	private String note;
	
	public Course() {
		
	}
	
/*	public Course(String OpenCourse, String CourseID,Date StartDate,Date EndDate, String Room, Integer RegisterMax,
	 String Teacher, String Note) {
		
		this.OpenCourse = OpenCourse;
		this.CourseID = CourseID;
		this.StartDate = StartDate;
		this.EndDate = EndDate;
		this.Room = Room;
		this.RegisterMax = RegisterMax;
		this.Teacher = Teacher;
		this.Note = Note;
	}*/

	public Integer getOpenCourse() {
		return openCourse;
	}

	public void setOpenCourse(Integer openCourse) {
		this.openCourse = openCourse;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Integer getRegisterMax() {
		return registerMax;
	}

	public void setRegisterMax(Integer registerMax) {
		this.registerMax = registerMax;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Course [openCourse=" + openCourse + ", courseID=" + courseID + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", room=" + room + ", registerMax=" + registerMax + ", teacher=" + teacher + ", note="
				+ note + "]";
	}

	
	

}
