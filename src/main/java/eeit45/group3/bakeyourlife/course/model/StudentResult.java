package eeit45.group3.bakeyourlife.course.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import eeit45.group3.bakeyourlife.user.model.User;
import java.util.Date;
import javax.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "course_student_result")
// @JsonIgnoreProperties(value = {"product", "user"})
public class StudentResult {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer strId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_product_id")
  private Product product;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_user_id")
  private User user;

  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  private Date time;

  private String strTitle;
  private String strContent;

  private String resultImageUrl;
  @Transient private MultipartFile resultFile;

  public StudentResult() {}

  public StudentResult(
      Integer strId,
      Product product,
      User user,
      Date time,
      String strTitle,
      String strContent,
      String resultImageUrl,
      MultipartFile resultFile) {
    this.strId = strId;
    this.product = product;
    this.user = user;
    this.time = time;
    this.strTitle = strTitle;
    this.strContent = strContent;
    this.resultImageUrl = resultImageUrl;
    this.resultFile = resultFile;
  }

  public Integer getStrId() {
    return strId;
  }

  public void setStrId(Integer strId) {
    this.strId = strId;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public String getUsername() {
    if (user != null) {
      return user.getUsername();
    } else {
      return null;
    }
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public String getStrContent() {
    return strContent;
  }

  public void setStrContent(String strContent) {
    this.strContent = strContent;
  }

  public String getResultImageUrl() {
    return resultImageUrl;
  }

  public void setResultImageUrl(String resultImageUrl) {
    this.resultImageUrl = resultImageUrl;
  }

  public MultipartFile getResultFile() {
    return resultFile;
  }

  public void setResultFile(MultipartFile resultFile) {
    this.resultFile = resultFile;
  }

  public String getStrTitle() {
    return strTitle;
  }

  public void setStrTitle(String strTitle) {
    this.strTitle = strTitle;
  }
}
