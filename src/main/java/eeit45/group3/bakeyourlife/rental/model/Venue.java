package eeit45.group3.bakeyourlife.rental.model;

import java.io.Serializable;
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
	@Column(name = "VenueName",columnDefinition = "varchar(5) not null unique")
	private String venueName;
	
	//人數上限
	@Column(name = "personMax",columnDefinition = "int not null")
	private Integer personMax;
	
	
	//對應場地清單
	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = false, mappedBy = "venue")
	private Set<VenueList> venueList = new LinkedHashSet<VenueList>();
	
	
	public Venue() {
	}


	public Venue(String venueName, Integer personMax, Set<VenueList> venueList) {
		this.venueName = venueName;
		this.personMax = personMax;
		this.venueList = venueList;
	}

	public Venue(String venueName, Integer personMax) {
		this.venueName = venueName;
		this.personMax = personMax;
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

	public Set<VenueList> getVenueList() {
		return venueList;
	}

	public void setVenueList(Set<VenueList> venueList) {
		this.venueList = venueList;
	}

	@Override
	public String toString() {
		return "Venue{" +
				"venueId=" + venueId +
				", venueName='" + venueName + '\'' +
				", personMax=" + personMax +
				", venueList=" + venueList +
				'}';
	}
}

