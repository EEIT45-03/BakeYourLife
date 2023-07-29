package eeit45.group3.bakeyourlife.tackle.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import eeit45.group3.bakeyourlife.rental.model.TackleBag;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Tackle")
@Component
public class Tackle implements Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  // 器具ID (PK)
  @Id
  @Column(name = "tackleId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer tackleId;

  // 器具名稱
  @Column(name = "tackleName", columnDefinition = "varchar(200) not null unique")
  private String tackleName;

  // 器具規格
  @Column(name = "specification", columnDefinition = "varchar(max)")
  private String specification;

  // 圖片路徑
  //	@Column(name = "picture")
  //	private String picture;
  @JsonManagedReference
  @OneToMany(
      cascade = {CascadeType.ALL},
      orphanRemoval = true,
      mappedBy = "tackle")
  private List<TacklePicList> tacklePicList;

  // 價錢/天
  @Column(name = "dayPrice", columnDefinition = "int not null")
  private Integer dayPrice;

  // 損壞賠償
  @Column(name = "damages", columnDefinition = "int not null")
  private Integer damages;

  // 總數量
  @Column(name = "max", columnDefinition = "int not null")
  private Integer max;

  // 備註
  @Column(name = "notes", columnDefinition = "varchar(max)")
  private String notes;

  // 對應器具包

  @OneToMany(
      cascade = {CascadeType.ALL},
      mappedBy = "tackle")
  private Set<TackleBag> tackleBags = new LinkedHashSet<TackleBag>();

  @JsonManagedReference
  @ManyToOne(cascade = {CascadeType.PERSIST})
  @JoinColumn(name = "FK_sortId", referencedColumnName = "tackleSortId", nullable = false)
  private TackleSort tackleSort;

  @Transient private List<String> base64;

  @Transient private Integer sortId;

  public Tackle() {}

  public Tackle(
      String tackleName,
      String specification,
      List<TacklePicList> tacklePicList,
      Integer dayPrice,
      Integer damages,
      Integer max,
      String notes,
      Set<TackleBag> tackleBags,
      TackleSort tackleSort,
      List<String> base64,
      Integer sortId) {
    this.tackleName = tackleName;
    this.specification = specification;
    this.tacklePicList = tacklePicList;
    this.dayPrice = dayPrice;
    this.damages = damages;
    this.max = max;
    this.notes = notes;
    this.tackleBags = tackleBags;
    this.tackleSort = tackleSort;
    this.base64 = base64;
    this.sortId = sortId;
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

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(String specification) {
    this.specification = specification;
  }

  public List<TacklePicList> getTacklePicList() {
    return tacklePicList;
  }

  public void setTacklePicList(List<TacklePicList> tacklePicList) {
    this.tacklePicList = tacklePicList;
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

  public Set<TackleBag> getTackleBags() {
    return tackleBags;
  }

  public void setTackleBags(Set<TackleBag> tackleBags) {
    this.tackleBags = tackleBags;
  }

  public TackleSort getTackleSort() {
    return tackleSort;
  }

  public void setTackleSort(TackleSort tackleSort) {
    this.tackleSort = tackleSort;
  }

  public List<String> getBase64() {
    return base64;
  }

  public void setBase64(List<String> base64) {
    this.base64 = base64;
  }

  public Integer getSortId() {
    return sortId;
  }

  public void setSortId(Integer sortId) {
    this.sortId = sortId;
  }
}
