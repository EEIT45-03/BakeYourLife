package eeit45.group3.bakeyourlife.rental.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import eeit45.group3.bakeyourlife.user.model.User;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Rental")
@Component
public class Rental implements Serializable {

  private static final long serialVersionUID = 1L;

  // 自動生成PK
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "rentalId")
  private Integer rentalId;

  // 租借編號
  @Column(name = "rentalNo", columnDefinition = "varchar(15) not null unique")
  private String rentalNo;

  // 會員ID
  @OneToOne(cascade = {CascadeType.PERSIST})
  @JoinColumn(name = "userId", nullable = false)
  private User user;

  // 下單日期
  @Column
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date rentalDate;

  // 租借類別
  @Column(name = "listType", columnDefinition = "varchar(15) not null")
  private String type;

  // 場地租借清單
  @JsonManagedReference
  @OneToMany(
      cascade = {CascadeType.ALL},
      mappedBy = "rental",
      orphanRemoval = true)
  private Set<VenueList> venueList = new LinkedHashSet<VenueList>();

  // 器具租借清單
  @JsonManagedReference
  @OneToMany(
      cascade = {CascadeType.ALL},
      mappedBy = "rental")
  private Set<TackleList> tackleList = new LinkedHashSet<TackleList>();

  // 狀態(未下單、待付款、已付款、已退單，需補款)
  @Column(name = "state", nullable = false, columnDefinition = "varchar(20)")
  private String state;

  // 總價錢
  @Column(name = "total", columnDefinition = "int")
  private Integer total;

  @Column(name = "replenishment", columnDefinition = "int")
  private Integer replenishment;

  public Rental() {}

  public Rental(
      String rentalNo,
      User user,
      String type,
      Set<VenueList> venueList,
      Set<TackleList> tackleList,
      Integer total) {
    this.rentalNo = rentalNo;
    this.user = user;
    this.type = type;
    this.venueList = venueList;
    this.tackleList = tackleList;
    this.total = total;
  }

  public Integer getRentalId() {
    return rentalId;
  }

  public void setRentalId(Integer rentalId) {
    this.rentalId = rentalId;
  }

  public String getRentalNo() {
    return rentalNo;
  }

  public void setRentalNo(String rentalNo) {
    this.rentalNo = rentalNo;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getRentalDate() {
    return rentalDate;
  }

  public void setRentalDate(Date rentalDate) {
    this.rentalDate = rentalDate;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Set<VenueList> getVenueList() {
    return venueList;
  }

  public void setVenueList(Set<VenueList> venueList) {
    this.venueList = venueList;
  }

  public Set<TackleList> getTackleList() {
    return tackleList;
  }

  public void setTackleList(Set<TackleList> tackleList) {
    this.tackleList = tackleList;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Integer getReplenishment() {
    return replenishment;
  }

  public void setReplenishment(Integer replenishment) {
    this.replenishment = replenishment;
  }
}
