package eeit45.group3.bakeyourlife.course.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "CourseTime")
@Component
public class CourseTime implements Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  // 課程時間列表清單ID (PK)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ctimeId;

  // 清單編號
  @Column(name = "ctimeNo", columnDefinition = "varchar(12) not null")
  private String ctimeNo;

  // 開始時間
  @Column(name = "ctimeStartDate", nullable = false)
  @Temporal(value = TemporalType.TIMESTAMP)
  //    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd'T'HH:mm")
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private Date ctimeStartDate;

  // 結束時間
  @Column(name = "ctimeEndDate", nullable = false)
  @Temporal(value = TemporalType.TIMESTAMP)
  //    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd'T'HH:mm")
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private Date ctimeEndDate;

  // 清單備註
  @Column(name = "ctimeNote", columnDefinition = "varchar(20)")
  private String ctimeNote;

  // 課程
  @ManyToOne(cascade = {CascadeType.PERSIST})
  @JoinColumn(name = "FK_opCourseId", referencedColumnName = "openCourse", nullable = false)
  private Course course;

  public CourseTime() {}

  public CourseTime(
      Integer ctimeId,
      String ctimeNo,
      Date ctimeStartDate,
      Date ctimeEndDate,
      String ctimeNote,
      Course course) {
    this.ctimeId = ctimeId;
    this.ctimeNo = ctimeNo;
    this.ctimeStartDate = ctimeStartDate;
    this.ctimeEndDate = ctimeEndDate;
    this.ctimeNote = ctimeNote;
    this.course = course;
  }

  public Integer getCtimeId() {
    return ctimeId;
  }

  public void setCtimeId(Integer ctimeId) {
    this.ctimeId = ctimeId;
  }

  public String getCtimeNo() {
    return ctimeNo;
  }

  public void setCtimeNo(String ctimeNo) {
    this.ctimeNo = ctimeNo;
  }

  public Date getCtimeStartDate() {
    return ctimeStartDate;
  }

  public void setCtimeStartDate(Date ctimeStartDate) {
    this.ctimeStartDate = ctimeStartDate;
  }

  public Date getCtimeEndDate() {
    return ctimeEndDate;
  }

  public void setCtimeEndDate(Date ctimeEndDate) {
    this.ctimeEndDate = ctimeEndDate;
  }

  public String getCtimeNote() {
    return ctimeNote;
  }

  public void setCtimeNote(String ctimeNote) {
    this.ctimeNote = ctimeNote;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  //    @Override
  //    public String toString() {
  //        return "CourseTime{" +
  //                "ctimeId=" + ctimeId +
  //                ", ctimeNo='" + ctimeNo + '\'' +
  //                ", ctimeStartDate=" + ctimeStartDate +
  //                ", ctimeEndDate=" + ctimeEndDate +
  //                ", ctimeNote='" + ctimeNote + '\'' +
  //                ", course=" + course +
  //                '}';
  //    }
}
