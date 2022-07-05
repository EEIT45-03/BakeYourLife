package eeit45.group3.bakeyourlife.farmerproduct.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import eeit45.group3.bakeyourlife.order.model.CartItem;

@Entity
@Table(name = "FarmerProduct")
public class FarmerProductBean implements Serializable, CartItem {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer farmerProductId; // 小農商品Id
    private String type;// 產品類型
    private String name;// 名稱
    private Integer price;// 價格
    private Integer quantity;// 數量
    private String storage;// 保存方式
    private String contents;// 內容物
    @Column(columnDefinition = "nvarchar(600)")
    private String description;// 描述
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date launchedTime;// 上架時間
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date suspendTime;// 下架時間
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date violationTime;// 違規下架時間

    private Integer state;// 狀態 0上架 1下架 2違規下架

    @OneToMany(mappedBy = "farmerProductBean", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FarmerProductPic> farmerProductPicList;

    @Transient
    private List<String> pictureDataUrl;

    @OneToMany(mappedBy = "farmerProductBean", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ProductComment> productCommentList;


//	@Column(columnDefinition = "nvarchar(MAX)")
//	private String pictureDataUrl;// 圖片的dataurl
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "type_id", nullable = false)

    public FarmerProductBean() {

    }

    public FarmerProductBean(Integer farmerProductId, String type, String name, Integer price, Integer quantity, String storage, String contents, String description, Date launchedTime, Date suspendTime, Date violationTime, Integer state, List<FarmerProductPic> farmerProductPicList, List<String> pictureDataUrl, List<ProductComment> productCommentList) {
        this.farmerProductId = farmerProductId;
        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.storage = storage;
        this.contents = contents;
        this.description = description;
        this.launchedTime = launchedTime;
        this.suspendTime = suspendTime;
        this.violationTime = violationTime;
        this.state = state;
        this.farmerProductPicList = farmerProductPicList;
        this.pictureDataUrl = pictureDataUrl;
        this.productCommentList = productCommentList;
    }

    public Integer getFarmerProductId() {
        return farmerProductId;
    }

    public void setFarmerProductId(Integer farmerProductId) {
        this.farmerProductId = farmerProductId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLaunchedTime() {
        return launchedTime;
    }

    public void setLaunchedTime(Date launchedTime) {
        this.launchedTime = launchedTime;
    }

    public Date getSuspendTime() {
        return suspendTime;
    }

    public void setSuspendTime(Date suspendTime) {
        this.suspendTime = suspendTime;
    }

    public Date getViolationTime() {
        return violationTime;
    }

    public void setViolationTime(Date violationTime) {
        this.violationTime = violationTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<FarmerProductPic> getFarmerProductPicList() {
        return farmerProductPicList;
    }

    public void setFarmerProductPicList(List<FarmerProductPic> farmerProductPicList) {
        this.farmerProductPicList = farmerProductPicList;
    }

    public List<String> getPictureDataUrl() {
        return pictureDataUrl;
    }

    public void setPictureDataUrl(List<String> pictureDataUrl) {
        this.pictureDataUrl = pictureDataUrl;
    }

    public List<ProductComment> getProductCommentList() {
        return productCommentList;
    }

    public void setProductCommentList(List<ProductComment> productCommentList) {
        this.productCommentList = productCommentList;
    }

    @Override
    public String getCartNo() {
        return "F" + this.farmerProductId;
    }

    @Override
    public String getCartType() {
        return "小農";
    }

    @Override
    public Integer getCartPrice() {
        return this.price;
    }

    @Override
    public String getCartName() {
        return this.name;
    }

    @Override
    public boolean isEnable() {
        if (this.state == 0) {
            return true;
        }
        return false;
    }
}
