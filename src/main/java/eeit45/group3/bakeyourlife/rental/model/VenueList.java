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

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
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
	@Column(name = "venueListNo",columnDefinition = "varchar(12) not null unique")
	private String venueListNo;
	
	//租借場地
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="FK_venueId", referencedColumnName = "venueId")
	private Venue venue;

	//出租日期
	@Column(name = "rentalDate", nullable = false)
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rentalDate;

	//出租時段
	@Column(name = "period", nullable = false)
	private String period;

	//食材提供
	@Column(name = "ingredients",columnDefinition = "varchar(5) not null")
	private String ingredients;

	//人數
	@Column(name = "person",columnDefinition = "int", nullable = false)
	private Integer person;
	
	//價錢
	@Column(name = "price",columnDefinition = "int", nullable = false)
	private Integer price;
	
	//租借單
	@ManyToOne(cascade = CascadeType.PERSIST )
	@JoinColumn(name="FK_rentalId", referencedColumnName = "rentalId", nullable = false)
	private Rental rental;

	public VenueList() {

	}

	public VenueList(Rental rental) {
		this.rental = rental;
	}

	public VenueList(String venueListNo, Venue venue, Date rentalDate, String period, String ingredients, Integer person, Integer price, Rental rental) {
		this.venueListNo = venueListNo;
		this.venue = venue;
		this.rentalDate = rentalDate;
		this.period = period;
		this.ingredients = ingredients;
		this.person = person;
		this.price = price;
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

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public Integer getPerson() {
		return person;
	}

	public void setPerson(Integer person) {
		this.person = person;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}
}
