package eeit45.group3.bakeyourlife.rental.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


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
	private Date lendDate;

	//結束時間
	@Column(name = "endDate", nullable = false)
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date endDate;

	//歸還時間
	@Column(name = "returnDate")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date returnDate;
	
	//數量
	@Column(name = "quantity",columnDefinition = "int not null")
	private Integer quantity;
	
	//小計
	@Column(name = "price",columnDefinition = "int not null")
	private Integer price;

	//租借單
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="FK_rentalId", referencedColumnName = "rentalId", nullable = false)
	private Rental rental;

	//租借器具
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="FK_tackleId", referencedColumnName = "tackleId", nullable = false)
	private Tackle tackle;

	public TackleList() {
	}

	public TackleList(String tackleListNo, Date lendDate, Date endDate, Date returnDate, Integer quantity, Integer price, Rental rental, Tackle tackle) {
		this.tackleListNo = tackleListNo;
		this.lendDate = lendDate;
		this.endDate = endDate;
		this.returnDate = returnDate;
		this.quantity = quantity;
		this.price = price;
		this.rental = rental;
		this.tackle = tackle;
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

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public Tackle getTackle() {
		return tackle;
	}

	public void setTackle(Tackle tackle) {
		this.tackle = tackle;
	}

}
