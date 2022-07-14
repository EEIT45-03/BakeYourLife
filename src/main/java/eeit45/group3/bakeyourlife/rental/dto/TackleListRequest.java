package eeit45.group3.bakeyourlife.rental.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import eeit45.group3.bakeyourlife.rental.model.Rental;

public class TackleListRequest {


	private String tackleListNo;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date lendDate;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	private Integer total;

	private String state;

	private Rental rental;

	private Integer[] tackleIds;

	private Integer[] quantitys;

	private Integer[] prices;
	
	public TackleListRequest() {
	}

	public String getTackleListNo() {
		return tackleListNo;
	}

	public void setTackleListNo(String tackleListNo) {
		this.tackleListNo = tackleListNo;
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
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

	public Integer[] getTackleIds() {
		return tackleIds;
	}

	public void setTackleIds(Integer[] tackleIds) {
		this.tackleIds = tackleIds;
	}

	public Integer[] getQuantitys() {
		return quantitys;
	}

	public void setQuantitys(Integer[] quantitys) {
		this.quantitys = quantitys;
	}

	public Integer[] getPrices() {
		return prices;
	}

	public void setPrices(Integer[] prices) {
		this.prices = prices;
	}
}
