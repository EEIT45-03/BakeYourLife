package eeit45.group3.bakeyourlife.course.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import eeit45.group3.bakeyourlife.rental.model.Venue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Course")
public class Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//開課編號
	@Id
	@SequenceGenerator( name = "CoSeq", sequenceName = "open_course", allocationSize = 10 , initialValue = 1000 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "CoSeq")
	private Integer openCourse;

	//課程代號 連到courseType
//	@OneToOne(cascade = {CascadeType.PERSIST})
//	@JoinColumn(name = "courseId", nullable = false)
//	private CourseType courseType;

	@Column(nullable = false)
	private Integer courseId;

	@JsonFormat(timezone = "GMT+8")
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date startDate;

	@JsonFormat(timezone = "GMT+8")
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date endDate;

	//教室物件
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "FK_venueId", nullable = false)
	private Venue venue;
	//教室id
	@Transient
	private Integer clVenueId;
//	教室人數=課程人數上限
//	private Integer registerMax;

	//報名人數
//	@Column(columnDefinition = "number default 0")
	private Integer applicants;

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Integer getClVenueId() {
		return clVenueId;
	}

	public void setClVenueId(Integer clVenueId) {
		this.clVenueId = clVenueId;
	}

	@Column(name = "teacher",columnDefinition = "nvarchar(20) not null")
	private String teacher;

	@Column(name = "note",columnDefinition = "nvarchar(MAX)")
	private String note;
	
	public Course() {

	}

	public Integer getRoomId() {
		if(venue!=null) {
			return venue.getVenueId();
		}else {
			return this.clVenueId;
		}
	}

	public void setRoomId(Integer clVenueId) {
		this.clVenueId = clVenueId;
		this.venue = new Venue();
		this.setRoomId(clVenueId);
	}

	public Course(Integer openCourse, Integer courseId, Date startDate, Date endDate, Venue room, Integer roomId, Integer applicants, String teacher, String note) {
		this.openCourse = openCourse;
		this.courseId = courseId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.venue = room;
		this.clVenueId = roomId;
		this.applicants = applicants;
		this.teacher = teacher;
		this.note = note;
	}

	public Integer getOpenCourse() {
		return openCourse;
	}

	public void setOpenCourse(Integer openCourse) {
		this.openCourse = openCourse;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
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

	public Venue getRoom() {
		return venue;
	}

	public void setRoom(Venue venue) {
		this.venue = venue;
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

	public Integer getApplicants() {
		return applicants;
	}

	public void setApplicants(Integer applicants) {
		this.applicants = applicants;
	}

	@Override
	public String toString() {
		return "Course{" +
				"openCourse=" + openCourse +
				", courseId=" + courseId +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", room=" + venue +
				", roomId=" + clVenueId +
				", applicants=" + applicants +
				", teacher='" + teacher + '\'' +
				", note='" + note + '\'' +
				'}';
	}
}
