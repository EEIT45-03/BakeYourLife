package eeit45.group3.bakeyourlife.course.model;

import eeit45.group3.bakeyourlife.user.model.User;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "courseRegister")
public class Register implements Serializable {

  /** */
  private static final long serialVersionUID = 1L;
  // 報名編號
  @Id
  @SequenceGenerator(
      name = "ReSeq",
      sequenceName = "register",
      allocationSize = 1,
      initialValue = 2022012)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReSeq")
  private Integer registerId;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "FK_userId", referencedColumnName = "userId", nullable = false)
  private User user;

  private Integer attendance;
  private Integer totalPrice;

  //    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date registerDate;

  private Integer state = 0; // 狀態 0報名成功 1使用者取消報名 2管理者取消課程 3課程完成

  @ManyToOne
  @JoinColumn(name = "FK_opCourse", referencedColumnName = "openCourse", nullable = false)
  private Course course;

  public Register(
      Integer registerId,
      User user,
      Integer attendance,
      Integer totalPrice,
      Date registerDate,
      Integer state,
      Course course) {
    this.registerId = registerId;
    this.user = user;
    this.attendance = attendance;
    this.totalPrice = totalPrice;
    this.registerDate = registerDate;
    this.state = state;
    this.course = course;
  }

  public Register() {}

  // User Getter & Setter
  public String getUsername() {
    if (user != null) {
      return user.getUsername();
    } else {
      return null;
    }
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Integer getRegisterId() {
    return registerId;
  }

  public void setRegisterId(Integer registerId) {
    this.registerId = registerId;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Integer getAttendance() {
    return attendance;
  }

  public void setAttendance(Integer attendance) {
    this.attendance = attendance;
  }

  public Integer getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Integer totalPrice) {
    this.totalPrice = totalPrice;
  }

  @Override
  public String toString() {
    return "Register{"
        + "registerId="
        + registerId
        + ", user="
        + user
        + ", attendance="
        + attendance
        + ", totalPrice="
        + totalPrice
        + ", registerDate="
        + registerDate
        + ", state="
        + state
        + ", course="
        + course
        + '}';
  }
}
