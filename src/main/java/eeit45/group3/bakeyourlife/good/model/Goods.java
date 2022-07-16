package eeit45.group3.bakeyourlife.good.model;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eeit45.group3.bakeyourlife.order.model.CartItem;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="Member_GoodsTable3")
@Component
public class Goods implements CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;//名稱
	String element;//成分
	String origin;//產地
	String savetime;//保存期限
	String packages;//包裝價格

	String packagematerial;//種類
	String saveway;//保存方式
//	@JsonIgnore++
//	Blob image;
//	String fileName;

	String imageUrl;


	Timestamp admissionTime;  //Get Time that's moment .
	@Transient
//	MultipartFile productImage;

	MultipartFile[] productImage;
	String count;//數量

	String system;//上架狀態

	public String[] getImageUrlArray() {
		return imageUrl.split(",");
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(columnDefinition = "nvarchar(max)")
	String describe;//描述

	@Column(columnDefinition = "nvarchar(max)")
	String evaluation;//評論

	String stars;//星星數

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public Goods(Integer id, String name, String element, String origin, String savetime, String packages,
				 String packagematerial, String saveway, Timestamp admissionTime,
				 CommonsMultipartFile[] productImage, String count, String system, String describe, String stars,
				 String evaluation,String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.element = element;
		this.origin = origin;
		this.savetime = savetime;
		this.packages = packages;
		this.packagematerial = packagematerial;
		this.saveway = saveway;
//		this.image = image;
//		this.fileName = fileName;
		this.admissionTime = admissionTime;
		this.productImage = productImage;
		this.count = count;
		this.system = system;
		this.describe = describe;
		this.stars = stars;
		this.evaluation = evaluation;
		this.imageUrl = imageUrl;
	}
	public Goods() {
		super();
	}
	public Integer getId() {
		return id;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getSavetime() {
		return savetime;
	}
	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public String getPackagematerial() {
		return packagematerial;
	}
	public void setPackagematerial(String packagematerial) {
		this.packagematerial = packagematerial;
	}
	public String getSaveway() {
		return saveway;
	}
	public void setSaveway(String saveway) {
		this.saveway = saveway;
	}
//	public Blob getImage() {
//		return image;
//	}
//	public void setImage(Blob image) {
//		this.image = image;
//	}
//	public String getFileName() {
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
	public Timestamp getAdmissionTime() {
		return admissionTime;
	}
	public void setAdmissionTime(Timestamp admissionTime) {
		this.admissionTime = admissionTime;
	}
	public MultipartFile[] getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile[] productImage) {
		this.productImage = productImage;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}

	@Override
	public String getCartNo() {
		return "G" + this.id;
	}

	@Override
	public String getCartType() {
		return "烘培材料";
	}

	@Override
	public Integer getCartPrice() {
		return Integer.valueOf(this.packages);
	}

	@Override
	public String getCartName() {
		return this.name;
	}

	@Override
	public boolean isEnable() {
		return "上架中".equals(this.system);
	}
}