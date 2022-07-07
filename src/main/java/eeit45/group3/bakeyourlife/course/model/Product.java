package eeit45.group3.bakeyourlife.course.model;

import eeit45.group3.bakeyourlife.rental.model.VenueList;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="CourseProdcut")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private Integer price;
	@Lob
	private String image;
	@Transient
	private MultipartFile file;

	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = false, mappedBy = "cProduct")
	private Set<Course> courseSet = new LinkedHashSet<Course>();

	public Product(){
	}

	public Product(Long id, String name, String description, Integer price, String image, MultipartFile file, Set<Course> courseSet) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.file = file;
		this.courseSet = courseSet;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public Set<Course> getCourseSet() {
		return courseSet;
	}

	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", image='" + image + '\'' +
				", file=" + file +
				", courseSet=" + courseSet +
				'}';
	}
}
