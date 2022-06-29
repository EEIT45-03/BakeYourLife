package eeit45.group3.bakeyourlife.rental.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "VenueList")
@Component
public class VenueList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//場地清單ID PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "venueListId")
	private Integer venueListId;

	//清單編號
	@Column(name = "venueListNo",columnDefinition = "varchar(12) unique")
	private String venueListNo;
	
	//租借場地
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="FK_classId", referencedColumnName = "classId")
	private Classroom classroom;
	
	//出租時間
	@Column(name = "lendTime", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date lendTime;
	
	//歸還時間
	@Column(name = "returnTime", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date returnTime;
	
	//人數
	@Column(name = "person",columnDefinition = "int")
	private Integer person;
	
	//價錢
	@Column(name = "price",columnDefinition = "int")
	private Integer price_V;
	
	//租借單
	@ManyToOne(cascade = CascadeType.PERSIST )
	@JoinColumn(name="FK_rentalId", referencedColumnName = "rentalId", nullable = false)
	private Rental rental;

	public VenueList() {

	}


	public VenueList(Integer venueListId, String venueListNo, Date lendTime, Date returnTime,
			Integer person, Integer price, Classroom classroom, Rental rental) {
		this.venueListId = venueListId;
		this.venueListNo = venueListNo;
		this.classroom = classroom;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
		this.person = person;
		this.price_V = price;
		this.rental = rental;
	}


	public Integer getVenueListId() {
		return venueListId;
	}

	public void setVenueListId(Integer venueListId) {
		this.venueListId = venueListId;
	}

	public String getVenueListNo() {
		return venueListNo;
	}

	public void setVenueListNo(String venueListNo) {
		this.venueListNo = venueListNo;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public Date getLendTime() {
		return lendTime;
	}

	public void setLendTime(Date lendTime) {
		this.lendTime = lendTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public Integer getPerson() {
		return person;
	}

	public void setPerson(Integer person) {
		this.person = person;
	}

	public Integer getPrice() {
		return price_V;
	}

	public void setPrice(Integer price) {
		this.price_V = price;
	}
}
