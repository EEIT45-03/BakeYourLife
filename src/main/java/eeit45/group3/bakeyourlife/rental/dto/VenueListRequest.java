package eeit45.group3.bakeyourlife.rental.dto;

import java.util.Date;

import eeit45.group3.bakeyourlife.venue.model.Venue;
import org.springframework.format.annotation.DateTimeFormat;

import eeit45.group3.bakeyourlife.rental.model.*;

public class VenueListRequest {

	private Integer venueListId;
	private String venueListNo;

	private Integer venueId;

	private Venue venue;
	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date lendTime;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date endTime;
	
	private Integer person;


	private String ingredients;

	private Integer price;
	
	private Rental rental;
	
	public VenueListRequest() {
	}

	public VenueListRequest(Rental rental) {
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

	public Integer getVenueId() {
		return venueId;
	}

	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Date getLendTime() {
		return lendTime;
	}

	public void setLendTime(Date lendTime) {
		this.lendTime = lendTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getPerson() {
		return person;
	}

	public void setPerson(Integer person) {
		this.person = person;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
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

