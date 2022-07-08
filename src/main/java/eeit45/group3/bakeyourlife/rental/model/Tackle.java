package eeit45.group3.bakeyourlife.rental.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "Tackle")
@Component
public class Tackle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//器具ID (PK)
	@Id
	@Column(name = "tackleId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tackleId;
	
	//器具名稱
	@Column(name = "tackleName",columnDefinition = "varchar(10) not null unique")
	private String tackleName;

	//器具型號
	@Column(name = "productModel",columnDefinition = "varchar(max)")
	private String productModel;

	//器具規格
	@Column(name = "specification",columnDefinition = "varchar(max)")
	private String specification;

	//圖片
	@Column(name = "picture")
	private byte[] picture;
	
	//價錢/天
	@Column(name = "dayPrice",columnDefinition = "int not null")
	private Integer dayPrice;
	
	//總數量
	@Column(name = "max",columnDefinition = "int not null")
	private Integer max;
	
	//對應器具清單
	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = false, mappedBy = "tackle")
	private Set<TackleList> tackleList = new LinkedHashSet<TackleList>();

	public Tackle() {
	}

	public Tackle(String tackleName, String productModel, String specification, byte[] picture, Integer dayPrice, Integer max) {
		this.tackleName = tackleName;
		this.productModel = productModel;
		this.specification = specification;
		this.picture = picture;
		this.dayPrice = dayPrice;
		this.max = max;
	}

	public Integer getTackleId() {
		return tackleId;
	}

	public void setTackleId(Integer tackleId) {
		this.tackleId = tackleId;
	}

	public String getTackleName() {
		return tackleName;
	}

	public void setTackleName(String tackleName) {
		this.tackleName = tackleName;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Integer getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(Integer dayPrice) {
		this.dayPrice = dayPrice;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Set<TackleList> getTackleList() {
		return tackleList;
	}

	public void setTackleList(Set<TackleList> tackleList) {
		this.tackleList = tackleList;
	}


	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}


	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	@Override
	public String toString() {
		return "Tackle{" +
				"tackleId=" + tackleId +
				", tackleName='" + tackleName + '\'' +
				", productModel='" + productModel + '\'' +
				", specification='" + specification + '\'' +
				", picture=" + Arrays.toString(picture) +
				", dayPrice=" + dayPrice +
				", max=" + max +
				", tackleList=" + tackleList +
				'}';
	}
}
