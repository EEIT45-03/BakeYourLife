package eeit45.group3.bakeyourlife.venue.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Venue")
@Component
public class Venue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//教室ID PK
	@Id
	@Column(name = "venueId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venueId;

	//教室名稱
	@Column(name = "VenueName",columnDefinition = "varchar(max) not null", unique = true)
	private String venueName;
	
	//人數上限
	@Column(name = "personMax",columnDefinition = "int not null")
	private Integer personMax;

	//價錢/時
	@Column(name = "hrPrice",columnDefinition = "int not null")
	private Integer hrPrice;

	//圖片路徑

	@JsonManagedReference
	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = false, mappedBy = "venue")
	private List<VenuePicList> venuePicList ;

	//備註
	@Column(name = "notes", columnDefinition = "varchar(max)")
	private String notes;

	//對應種類
	@JsonManagedReference
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="FK_sortId", referencedColumnName = "venueSortId", nullable = false)
	private VenueSort venueSort;

	//對應場地清單
	@JsonManagedReference
	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = false, mappedBy = "venue")
	@Column(name = "picList")
	private Set<VenueList> venueList = new LinkedHashSet<VenueList>();

	@Transient
	private List<String> base64;

	@Transient
	private String sort;

	public Venue() {
	}

	public Venue(String venueName, Integer personMax, Integer hrPrice, List<VenuePicList> venuePicList, String notes, VenueSort venueSort, Set<VenueList> venueList, List<String> base64, String sort) {
		this.venueName = venueName;
		this.personMax = personMax;
		this.hrPrice = hrPrice;
		this.venuePicList = venuePicList;
		this.notes = notes;
		this.venueSort = venueSort;
		this.venueList = venueList;
		this.base64 = base64;
		this.sort = sort;
	}

	public Integer getVenueId() {
		return venueId;
	}

	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public Integer getPersonMax() {
		return personMax;
	}

	public void setPersonMax(Integer personMax) {
		this.personMax = personMax;
	}

	public Integer getHrPrice() {
		return hrPrice;
	}

	public void setHrPrice(Integer hrPrice) {
		this.hrPrice = hrPrice;
	}

	public List<VenuePicList> getVenuePicList() {
		return venuePicList;
	}

	public void setVenuePicList(List<VenuePicList> venuePicList) {
		this.venuePicList = venuePicList;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public VenueSort getVenueSort() {
		return venueSort;
	}

	public void setVenueSort(VenueSort venueSort) {
		this.venueSort = venueSort;
	}

	public Set<VenueList> getVenueList() {
		return venueList;
	}

	public void setVenueList(Set<VenueList> venueList) {
		this.venueList = venueList;
	}

	public List<String> getBase64() {
		return base64;
	}

	public void setBase64(List<String> base64) {
		this.base64 = base64;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}

