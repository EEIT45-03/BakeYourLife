package eeit45.group3.bakeyourlife.tackle.model;

import eeit45.group3.bakeyourlife.rental.model.TackleList;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


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
	@Column(name = "tackleName",columnDefinition = "varchar(20) not null unique")
	private String tackleName;

	//器具規格
	@Column(name = "specification",columnDefinition = "varchar(max)")
	private String specification;

	//圖片路徑
	@Column(name = "picture")
	private String picture;
	
	//價錢/天
	@Column(name = "dayPrice",columnDefinition = "int not null")
	private Integer dayPrice;

	//損壞賠償
	@Column(name = "damages",columnDefinition = "int not null")
	private Integer damages;
	
	//總數量
	@Column(name = "max",columnDefinition = "int not null")
	private Integer max;

	//備註
	@Column
	private String notes;
	
	//對應器具清單
	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = false, mappedBy = "tackle")
	private Set<TackleList> tackleList = new LinkedHashSet<TackleList>();

	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="FK_sortId", referencedColumnName = "tackleSortId", nullable = false)
	private TackleSort tackleSort;

	@Transient
	private MultipartFile tackleImage;

	public Tackle() {
	}

//	public Tackle(String tackleName, String productModel, String picture, Integer dayPrice, Integer max) {
//		this.tackleName = tackleName;
//		this.specification = specification;
//		this.picture = picture;
//		this.dayPrice = dayPrice;
//		this.max = max;
//	}
//
//	public Tackle(String tackleName, String specification, String picture, Integer dayPrice, Integer damages, Integer max, String notes, MultipartFile tackleImage) {
//		this.tackleName = tackleName;
//		this.specification = specification;
//		this.picture = picture;
//		this.dayPrice = dayPrice;
//		this.damages = damages;
//		this.max = max;
//		this.notes = notes;
//		this.tackleImage = tackleImage;
//	}

	public Tackle(String tackleName, String specification, String picture, Integer dayPrice, Integer damages, Integer max, String notes, TackleSort tackleSort, MultipartFile tackleImage) {
		this.tackleName = tackleName;
		this.specification = specification;
		this.picture = picture;
		this.dayPrice = dayPrice;
		this.damages = damages;
		this.max = max;
		this.notes = notes;
		this.tackleSort = tackleSort;
		this.tackleImage = tackleImage;
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

//	public String getProductModel() {
//		return productModel;
//	}
//
//	public void setProductModel(String productModel) {
//		this.productModel = productModel;
//	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(Integer dayPrice) {
		this.dayPrice = dayPrice;
	}

	public Integer getDamages() {
		return damages;
	}

	public void setDamages(Integer damages) {
		this.damages = damages;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Set<TackleList> getTackleList() {
		return tackleList;
	}

	public void setTackleList(Set<TackleList> tackleList) {
		this.tackleList = tackleList;
	}

	public MultipartFile getTackleImage() {
		return tackleImage;
	}

	public void setTackleImage(MultipartFile tackleImage) {
		this.tackleImage = tackleImage;
	}

	public TackleSort getTackleSort() {
		return tackleSort;
	}

	public void setTackleSort(TackleSort tackleSort) {
		this.tackleSort = tackleSort;
	}
}