package eeit45.group3.bakeyourlife.farmerproduct.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "FarmerProductPic")
@JsonIgnoreProperties("farmerProductBean")
public class FarmerProductPic implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer picId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "farmer_product_id")
  private FarmerProductBean farmerProductBean;

  //    @Column(columnDefinition = "nvarchar(MAX)")
  //    private String pictureDataUrl;// 圖片的dataurl

  private String pictureLink; // 圖片的連結

  //    private String pictureDeleteHash;//刪除碼

  public FarmerProductPic() {}

  public FarmerProductPic(Integer picId, FarmerProductBean farmerProductBean, String pictureLink) {
    this.picId = picId;
    this.farmerProductBean = farmerProductBean;
    this.pictureLink = pictureLink;
  }

  public Integer getPicId() {
    return picId;
  }

  public void setPicId(Integer picId) {
    this.picId = picId;
  }

  public FarmerProductBean getFarmerProductBean() {
    return farmerProductBean;
  }

  public void setFarmerProductBean(FarmerProductBean farmerProductBean) {
    this.farmerProductBean = farmerProductBean;
  }

  public String getPictureLink() {
    return pictureLink;
  }

  public void setPictureLink(String pictureLink) {
    this.pictureLink = pictureLink;
  }
}
