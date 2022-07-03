package eeit45.group3.bakeyourlife.rental.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import eeit45.group3.bakeyourlife.rental.model.Rental;

public class TackleListRequest {

	private Integer tackleListId;
	private String tackleListNo;
	
	private Integer tackleId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date lendDate;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date returnDate;
	
	private Integer quantity;
	
	private Integer price;


	private String state;

	private Rental rental;
	
	public TackleListRequest() {
	}

	public Integer getTackleListId() {
		return tackleListId;
	}

	public void setTackleListId(Integer tackleListId) {
		this.tackleListId = tackleListId;
	}

	public TackleListRequest(Rental rental) {
		this.rental = rental;
	}

	public String getTackleListNo() {
		return tackleListNo;
	}

	public void setTackleListNo(String tackleListNo) {
		this.tackleListNo = tackleListNo;
	}

	public Integer getTackleId() {
		return tackleId;
	}

	public void setTackleId(Integer tackleId) {
		this.tackleId = tackleId;
	}

	public Date getLendDate() {
		return lendDate;
	}

	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}
}
