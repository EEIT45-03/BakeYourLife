package eeit45.group3.bakeyourlife.farmerproduct.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FarmerProductPic")
public class FarmerProductPic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer picId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_product_id")
    private FarmerProductBean farmerProductBean;

    @Column(columnDefinition = "nvarchar(MAX)")
    private String pictureDataUrl;// 圖片的dataurl

    public FarmerProductPic() {
    }

    public FarmerProductPic(Integer picId, FarmerProductBean farmerProductBean, String pictureDataUrl) {
        this.picId = picId;
        this.farmerProductBean = farmerProductBean;
        this.pictureDataUrl = pictureDataUrl;
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

    public String getPictureDataUrl() {
        return pictureDataUrl;
    }

    public void setPictureDataUrl(String pictureDataUrl) {
        this.pictureDataUrl = pictureDataUrl;
    }
}