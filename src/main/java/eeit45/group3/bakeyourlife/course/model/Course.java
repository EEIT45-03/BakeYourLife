package eeit45.group3.bakeyourlife.course.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.TackleList;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

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

	@ManyToOne(cascade = CascadeType.PERSIST )
	@JoinColumn(name="FK_cProductId", referencedColumnName = "Id", nullable = false)
	private Product cProduct;

	@Column(nullable = false)
	private Integer hours;

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
	//課程時段
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "course")
	private Set<CourseTime> courseTimes = new LinkedHashSet<CourseTime>();

	//教室id
	@Transient
	private Integer clVenueId;
//	教室人數=課程人數上限


	//報名人數
	private Integer applicants;

	@Column(name = "teacher",columnDefinition = "nvarchar(20) not null")
	private String teacher;

	@Column(name = "note",columnDefinition = "nvarchar(MAX)")
	private String note;


	
	public Course() {

	}

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

	public Course(Integer openCourse, Product cProduct, Integer hours, Date startDate, Date endDate, Venue venue, Set<CourseTime> courseTimes, Integer clVenueId, Integer applicants, String teacher, String note) {
		this.openCourse = openCourse;
		this.cProduct = cProduct;
		this.hours = hours;
		this.startDate = startDate;
		this.endDate = endDate;
		this.venue = venue;
		this.courseTimes = courseTimes;
		this.clVenueId = clVenueId;
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

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
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

	public Product getcProduct() {
		return cProduct;
	}

	public void setcProduct(Product cProduct) {
		this.cProduct = cProduct;
	}

	public Set<CourseTime> getCourseTimes() {
		return courseTimes;
	}

	public void setCourseTimes(Set<CourseTime> courseTimes) {
		this.courseTimes = courseTimes;
	}

	@Override
	public String toString() {
		return "Course{" +
				"openCourse=" + openCourse +
				", cProduct=" + cProduct +
				", hours=" + hours +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", venue=" + venue +
				", courseTimes=" + courseTimes +
				", clVenueId=" + clVenueId +
				", applicants=" + applicants +
				", teacher='" + teacher + '\'' +
				", note='" + note + '\'' +
				'}';
	}
}
