package eeit45.group3.bakeyourlife.user.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;
@Entity
@Table(name = "Farmers")
public class Farmer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer farmerId;
    @Column(unique = true)
    private String username;
    private String password;
    private String authority;
    private String farmerName;
    private String farmerInfo;
    private String email;
    private String phone;
    private String address;

    private Timestamp registerTime;
    @Transient
    MultipartFile productImage;

    private  String imageUrl;

    public Farmer() {
    }

    public Farmer(Integer farmerId, String username, String password, String authority, String farmerName, String farmerInfo, String email, String phone, String address, Timestamp registerTime, MultipartFile productImage,String imageUrl) {
        this.farmerId = farmerId;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.farmerName = farmerName;
        this.farmerInfo = farmerInfo;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.registerTime = registerTime;
        this.productImage = productImage;
        this.imageUrl = imageUrl;

    }

    public Farmer(String username, String password, String authority, String farmerName, String farmerInfo, String email, String phone, String address, Timestamp registerTime, MultipartFile productImage,String imageUrl) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.farmerName = farmerName;
        this.farmerInfo = farmerInfo;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.registerTime = registerTime;
        this.productImage = productImage;
        this.imageUrl = imageUrl;

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerInfo() {
        return farmerInfo;
    }

    public void setFarmerInfo(String farmerInfo) {
        this.farmerInfo = farmerInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }
}
