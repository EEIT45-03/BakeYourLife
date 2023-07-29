package eeit45.group3.bakeyourlife.course.model;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "CourseProdcut")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String summary;
  private String description;
  private Integer price;
  private String image;
  @Transient private MultipartFile file;

  @OneToMany(
      cascade = {CascadeType.ALL},
      orphanRemoval = false,
      mappedBy = "cProduct")
  private Set<Course> courseSet = new LinkedHashSet<Course>();

  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Set<StudentResult> studentResultSet;

  //	@ManyToOne(fetch = FetchType.LAZY)
  //	@JoinColumn(name = "fk_user_id")
  //	private User user;

  public Product() {}

  public Product(
      Long id,
      String name,
      String summary,
      String description,
      Integer price,
      String image,
      MultipartFile file,
      Set<Course> courseSet) {
    this.id = id;
    this.name = name;
    this.summary = summary;
    this.description = description;
    this.price = price;
    this.image = image;
    this.file = file;
    this.courseSet = courseSet;
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

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
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

  public MultipartFile getFile() {
    return file;
  }

  public void setFile(MultipartFile file) {
    this.file = file;
  }

  public Set<Course> getCourseSet() {
    return courseSet;
  }

  public void setCourseSet(Set<Course> courseSet) {
    this.courseSet = courseSet;
  }
}
