package eeit45.group3.bakeyourlife.good.model;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import eeit45.group3.bakeyourlife.order.model.CartItem;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Goods")
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
    
    String packagematerial;//包裝材質
    String saveway;//保存方式
    Blob image;
    String fileName;
    Timestamp admissionTime;  //Get Time that's moment .
    @Transient
    MultipartFile productImage;
	public Goods(Integer id, String name, String element, String origin, String savetime, String packages,
			String packagematerial, String saveway, Blob image, String fileName, Timestamp admissionTime,
			MultipartFile productImage) {
		super();
		this.id = id;
		this.name = name;
		this.element = element;
		this.origin = origin;
		this.savetime = savetime;
		this.packages = packages;
		this.packagematerial = packagematerial;
		this.saveway = saveway;
		this.image = image;
		this.fileName = fileName;
		this.admissionTime = admissionTime;
		this.productImage = productImage;
	}
	public Goods() {
		super();
	}
	public Integer getId() {
		return id;
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
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Timestamp getAdmissionTime() {
		return admissionTime;
	}
	public void setAdmissionTime(Timestamp admissionTime) {
		this.admissionTime = admissionTime;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}


	@Override
	public String getCartNo() {
		return "G" + id;
	}

	@Override
	public String getCartType() {
		return "烘培材料";
	}

	@Override
	public Integer getCartPrice() {
		return Integer.valueOf(packages);
	}

	@Override
	public String getCartName() {
		return name;
	}

	@Override
	public boolean isEnable() {
		return false;
	}
}