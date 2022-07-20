package eeit45.group3.bakeyourlife.rental.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "TackleList")
@Component
public class TackleList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//器具清單ID (PK)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tackleListId;
	
	//清單編號
	@Column(name = "tackleListNo",columnDefinition = "varchar(12) not null unique")
	public String tackleListNo;

	
	//出租時間
	@Column(name = "lendDate", nullable = false)
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lendDate;

	//結束時間
	@Column(name = "endDate", nullable = false)
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	//歸還時間
	@Column(name = "returnDate")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;

	//合計
	@Column(name = "total",columnDefinition = "int not null")
	private Integer total;

	//狀態(未借出、已借出、已歸還、遲歸還)
	@Column(name = "state", nullable = false, columnDefinition = "varchar(20)")
	private String state;

	//器具包
	@OneToOne(cascade = {CascadeType.ALL}, mappedBy = "tackleList")
	private TackleBag tackleBag;

	//租借單
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Rental rental;



	public TackleList() {
	}

	public TackleList(String tackleListNo, Date lendDate, Date endDate, Date returnDate, Integer total, String state, TackleBag tackleBag, Rental rental) {
		this.tackleListNo = tackleListNo;
		this.lendDate = lendDate;
		this.endDate = endDate;
		this.returnDate = returnDate;
		this.total = total;
		this.state = state;
		this.tackleBag = tackleBag;
		this.rental = rental;
	}

	public Integer getTackleListId() {
		return tackleListId;
	}

	public void setTackleListId(Integer tackleListId) {
		this.tackleListId = tackleListId;
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

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
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

	public TackleBag getTackleBag() {
		return tackleBag;
	}

	public void setTackleBag(TackleBag tackleBag) {
		this.tackleBag = tackleBag;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}
}
