package eeit45.group3.bakeyourlife.farmerproduct.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "FarmerProduct")
public class FarmerProductBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer farmerProductId;
//	private Integer farmerProductNo;
//	private Integer farmerApplyListNo;
	private String farmerProductName;
	private Integer farmerProductPrice;
	private Integer farmerProductQuantity;
	private String farmerProductStorage;
	private String farmerProductContent;
	@Column(columnDefinition = "nvarchar(600)")
	private String farmerProductDescription;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date farmerProductLaunchedTime;// 上架時間
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date farmerProductSoldTime;// 下價時間
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date farmerProductApplyTime;// 申請時間
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date farmerProductCheckTime;// 審核時間

	private Integer farmerProductState;// 狀態 0審核中 1上架 2未通過 3下架

	@Column(columnDefinition = "nvarchar(MAX)")
	private String farmerProductPicDataUrl;

//	@Column(columnDefinition = "varbinary(MAX)")
//	private byte[] farmerProductPic;

	public FarmerProductBean() {

	}

	public FarmerProductBean(Integer farmerProductId, String farmerProductName, Integer farmerProductPrice,
			Integer farmerProductQuantity, String farmerProductContent, String farmerProductStorage,
			String farmerProductDescription, Date farmerProductLaunchedTime, Date farmerProductSoldTime,
			Date farmerProductApplyTime, Date farmerProductCheckTime, Integer farmerProductState,
			String farmerProductPicDataUrl) {
		this.farmerProductId = farmerProductId;
		this.farmerProductName = farmerProductName;
		this.farmerProductPrice = farmerProductPrice;
		this.farmerProductQuantity = farmerProductQuantity;
		this.farmerProductContent = farmerProductContent;
		this.farmerProductStorage = farmerProductStorage;
		this.farmerProductDescription = farmerProductDescription;
		this.farmerProductLaunchedTime = farmerProductLaunchedTime;
		this.farmerProductSoldTime = farmerProductSoldTime;
		this.farmerProductApplyTime = farmerProductApplyTime;
		this.farmerProductCheckTime = farmerProductCheckTime;
		this.farmerProductState = farmerProductState;
		this.farmerProductPicDataUrl = farmerProductPicDataUrl;
	}

	public Integer getFarmerProductId() {
		return farmerProductId;
	}

	public void setFarmerProductId(Integer farmerProductId) {
		this.farmerProductId = farmerProductId;
	}

	public String getFarmerProductName() {
		return farmerProductName;
	}

	public void setFarmerProductName(String farmerProductName) {
		this.farmerProductName = farmerProductName;
	}

	public Integer getFarmerProductPrice() {
		return farmerProductPrice;
	}

	public void setFarmerProductPrice(Integer farmerProductPrice) {
		this.farmerProductPrice = farmerProductPrice;
	}

	public Integer getFarmerProductQuantity() {
		return farmerProductQuantity;
	}

	public void setFarmerProductQuantity(Integer farmerProductQuantity) {
		this.farmerProductQuantity = farmerProductQuantity;
	}

	public String getFarmerProductContent() {
		return farmerProductContent;
	}

	public void setFarmerProductContent(String farmerProductContent) {
		this.farmerProductContent = farmerProductContent;
	}

	public String getFarmerProductStorage() {
		return farmerProductStorage;
	}

	public void setFarmerProductStorage(String farmerProductStorage) {
		this.farmerProductStorage = farmerProductStorage;
	}

	public String getFarmerProductDescription() {
		return farmerProductDescription;
	}

	public void setFarmerProductDescription(String farmerProductDescription) {
		this.farmerProductDescription = farmerProductDescription;
	}

	public Date getFarmerProductLaunchedTime() {
		return farmerProductLaunchedTime;
	}

	public void setFarmerProductLaunchedTime(Date farmerProductLaunchedTime) {
		this.farmerProductLaunchedTime = farmerProductLaunchedTime;
	}

	public Date getFarmerProductSoldTime() {
		return farmerProductSoldTime;
	}

	public void setFarmerProductSoldTime(Date farmerProductSoldTime) {
		this.farmerProductSoldTime = farmerProductSoldTime;
	}

	public Date getFarmerProductApplyTime() {
		return farmerProductApplyTime;
	}

	public void setFarmerProductApplyTime(Date farmerProductApplyTime) {
		this.farmerProductApplyTime = farmerProductApplyTime;
	}

	public Date getFarmerProductCheckTime() {
		return farmerProductCheckTime;
	}

	public void setFarmerProductCheckTime(Date farmerProductCheckTime) {
		this.farmerProductCheckTime = farmerProductCheckTime;
	}

	public Integer getFarmerProductState() {
		return farmerProductState;
	}

	public void setFarmerProductState(Integer farmerProductState) {
		this.farmerProductState = farmerProductState;
	}

	public String getFarmerProductPicDataUrl() {
		return farmerProductPicDataUrl;
	}

	public void setFarmerProductPicDataUrl(String farmerProductPicDataUrl) {
		this.farmerProductPicDataUrl = farmerProductPicDataUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {

		return "FarmerProductBean [farmerProductId=" + farmerProductId + ", farmerProductName=" + farmerProductName
				+ ", farmerProductPrice=" + farmerProductPrice + ", farmerProductQuantity=" + farmerProductQuantity
				+ ", farmerProductStorage=" + farmerProductStorage + ", farmerProductContent=" + farmerProductContent
				+ ", farmerProductDescription=" + farmerProductDescription + ", farmerProductLaunchedTime="
				+ farmerProductLaunchedTime + ", farmerProductSoldTime=" + farmerProductSoldTime
				+ ", farmerProductApplyTime=" + farmerProductApplyTime + ", farmerProductCheckTime="
				+ farmerProductCheckTime + ", farmerProductState=" + farmerProductState + "]";
	}

}
