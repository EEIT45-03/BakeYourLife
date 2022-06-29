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
	
	//租借器具
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="FK_tackleId", referencedColumnName = "tackleId")
	private Tackle tackle;
	
	//出租時間
	@Column(name = "lendTime", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date lendTime;
	
	//歸還時間
	@Column(name = "returnTime", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date returnTime;
	
	//數量
	@Column(name = "quantity",columnDefinition = "int not null")
	private Integer quantity;
	
	//價錢
	@Column(name = "price",columnDefinition = "int not null")
	private Integer price_T;
	
	//租借單
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="FK_rentalId", referencedColumnName = "rentalId", nullable = false)
	public Rental rental_T;

	public TackleList(Integer tackleListId, String tackleListNo, Tackle tackle, Date lendTime, Date returnTime,
			Integer quantity, Integer price, Rental rental) {
		this.tackleListId = tackleListId;
		this.tackleListNo = tackleListNo;
		this.tackle = tackle;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
		this.quantity = quantity;
		this.price_T = price;
		this.rental_T = rental;
	}

	public TackleList(String tackleListNo, Tackle tackle, Date lendTime, Date returnTime, Integer quantity,
			Integer price, Rental rental) {
		this.tackleListNo = tackleListNo;
		this.tackle = tackle;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
		this.quantity = quantity;
		this.price_T = price;
		this.rental_T = rental;
	}

	public TackleList() {
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

	public Tackle getTackle() {
		return tackle;
	}

	public void setTackle(Tackle tackle) {
		this.tackle = tackle;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price_T;
	}

	public void setPrice(Integer price) {
		this.price_T = price;
	}

	public Rental getRental() {
		return rental_T;
	}

	public void setRental(Rental rental_T) {
		this.rental_T = rental_T;
	}

}
