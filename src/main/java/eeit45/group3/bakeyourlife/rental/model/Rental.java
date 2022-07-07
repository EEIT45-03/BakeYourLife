package eeit45.group3.bakeyourlife.rental.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import eeit45.group3.bakeyourlife.user.model.User;


@Entity
@Table(name = "Rental")
@Component
public class Rental implements Serializable {

    private static final long serialVersionUID = 1L;

    //自動生成PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentalId")
    private Integer rentalId;

    //租借編號
    @Column(name = "rentalNo", columnDefinition = "varchar(15) not null unique")
    private String rentalNo;

    //會員ID
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    //下單日期
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rentalDate;

    //租借類別
    @Column(name = "listType", columnDefinition = "varchar(15) not null")
    private String type;

    //場地租借清單
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "rental", orphanRemoval = true)
    private Set<VenueList> venueList = new LinkedHashSet<VenueList>();

    //器具租借清單
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "rental")
    private Set<TackleList> tackleList = new LinkedHashSet<TackleList>();

    //消費狀態(待付款、已付款、未領取、已領取、未歸還、已歸還)
    @Column(name = "state",columnDefinition = "varchar(10)")
    private String state;

    //總價錢
    @Column(name = "total", columnDefinition = "int")
    private Integer total;

    //遲歸還補款
    @Transient
    @Column(name = "replenishment", columnDefinition = "int")
    private Integer replenishment;

    public Rental() {
    }

    public Rental(String rentalNo, User user, String type, Set<VenueList> venueList, Set<TackleList> tackleList,
                  Integer total) {
        this.rentalNo = rentalNo;
        this.user = user;
        this.type = type;
        this.venueList = venueList;
        this.tackleList = tackleList;
        this.total = total;
    }

    public Rental(String rentalNo, User user, Date rentalDate, String type, Set<VenueList> venueList, Set<TackleList> tackleList, String state, Integer total, Integer replenishment) {
        this.rentalNo = rentalNo;
        this.user = user;
        this.rentalDate = rentalDate;
        this.type = type;
        this.venueList = venueList;
        this.tackleList = tackleList;
        this.state = state;
        this.total = total;
        this.replenishment = replenishment;
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
