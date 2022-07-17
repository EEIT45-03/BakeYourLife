package eeit45.group3.bakeyourlife.user.model;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Users")

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(unique = true)
    private String username;
    private String password;

    private String authority;
    private String fullName;
    private String email;
    private String phone;
    private String birth;
    private String gender;
    private String address;
    private Timestamp registerTime;

    @Transient
    MultipartFile productImage;

    private String imageUrl;


    public User() {
        super();
    }

    public User(String username, String password, String authority, String fullName, String email, String phone, String birth, String gender, String address) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
    }

    public User(Integer userId, String username, String password, String authority, String fullName, String email, String phone,
                String birth, String gender, String address, Timestamp registerTime, MultipartFile productImage, String imageUrl) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
        this.registerTime = registerTime;
        this.productImage = productImage;
        this.imageUrl = imageUrl;


    }

    public User(String username, String password, String authority, String fullName, String email, String phone, String birth,
                String gender, String address, Timestamp registerTime, MultipartFile productImage, String imageUrl) {
        super();
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birth = birth;
        this.gender = gender;
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authority='" + authority + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", registerTime=" + registerTime +
                ", productImage=" + productImage +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
