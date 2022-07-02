package eeit45.group3.bakeyourlife.rental.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    @Column(name = "rentalNO", columnDefinition = "varchar(15) not null unique")
    private String rentalNO;

    //會員ID
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    //租借類別
    @Column(name = "listType", columnDefinition = "varchar(15) not null")
    private String type;

    //場地租借清單
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "rental", orphanRemoval = true)
    private Set<VenueList> venueList = new LinkedHashSet<VenueList>();

    //器具租借清單
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "rental_T")
    private Set<TackleList> tackleList = new LinkedHashSet<TackleList>();

    //總價錢
    @Column(name = "total", columnDefinition = "int")
    private Integer total;


    public Rental() {
    }

    public Rental(Integer rentalId, String rentalNO, User user, String type, Set<VenueList> venueList, Set<TackleList> tackleList, Integer total) {
        this.rentalId = rentalId;
        this.rentalNO = rentalNO;
        this.user = user;
        this.type = type;
        this.venueList = venueList;
        this.tackleList = tackleList;
        this.total = total;
    }


    public Rental(String rentalNO, User user, String type, Set<VenueList> venueList, Set<TackleList> tackleList,
                  Integer total) {
        this.rentalNO = rentalNO;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<VenueList> getVenueList() {
        return venueList;
    }

    public void setVenueList(Set<VenueList> venueList) {
        this.venueList = venueList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRentalNO() {
        return rentalNO;
    }

    public void setRentalNO(String rentalNO) {
        this.rentalNO = rentalNO;
    }

    public Set<TackleList> getTackleList() {
        return tackleList;
    }

    public void setTackleList(Set<TackleList> tackleList) {
        this.tackleList = tackleList;
    }


}
