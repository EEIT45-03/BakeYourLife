package eeit45.group3.bakeyourlife.rental.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RentalRequest {

	private Integer rentalId;
	private String rentalNo;
	
	private String listType;

	private Integer userId;
	
	private Integer total ;

	private String[] venueListNo;	

	private String[] tackleListNo;	
	
	private Integer[] FK_classId;
	
	private Integer[] FK_tackleId;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date[] lendTime;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date[] returnTime;
	
	private Integer[] person;
	
	private Integer[] quantity;
	
	private Integer[] price;

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

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	public RentalRequest() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String[] getVenueListNo() {
		return venueListNo;
	}

	public void setVenueListNo(String[] venueListNo) {
		this.venueListNo = venueListNo;
	}

	public String[] getTackleListNo() {
		return tackleListNo;
	}

	public void setTackleListNo(String[] tackleListNo) {
		this.tackleListNo = tackleListNo;
	}

	public Integer[] getFK_classId() {
		return FK_classId;
	}

	public void setFK_classId(Integer[] fK_classId) {
		FK_classId = fK_classId;
	}

	public Integer[] getFK_tackleId() {
		return FK_tackleId;
	}

	public void setFK_tackleId(Integer[] fK_tackleId) {
		FK_tackleId = fK_tackleId;
	}

	public Date[] getLendTime() {
		return lendTime;
	}

	public void setLendTime(Date[] lendTime) {
		this.lendTime = lendTime;
	}

	public Date[] getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date[] returnTime) {
		this.returnTime = returnTime;
	}

	public Integer[] getPerson() {
		return person;
	}

	public void setPerson(Integer[] person) {
		this.person = person;
	}

	public Integer[] getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer[] quantity) {
		this.quantity = quantity;
	}

	public Integer[] getPrice() {
		return price;
	}

	public void setPrice(Integer[] price) {
		this.price = price;
	}
}
