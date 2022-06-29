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
@Table(name = "class")
@Component
public class Classroom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//教室ID PK
	@Id
	@Column(name = "classId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer classId;

	//教室名稱
	@Column(name = "className",columnDefinition = "varchar(5) not null unique")
	private String className;
	
	//人數上限
	@Column(name = "personMax",columnDefinition = "int not null")
	private Integer personMax;
	
	
	//對應場地清單
	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = false, mappedBy = "classroom")
	private Set<VenueList> venueList = new LinkedHashSet<VenueList>();
	
	
	public Classroom() {
	}
	
	
	public Classroom(Integer classId, String className, Integer personMax ,Set<VenueList> venueList) {
		this.classId = classId;
		this.className = className;
		this.personMax = personMax;
		this.venueList = venueList;
	}
	

	public Classroom(String className, Integer personMax) {
		this.className = className;
		this.personMax = personMax;
	}


	public Integer getClassId() {
		return classId;
	}
	
	
	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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
}

