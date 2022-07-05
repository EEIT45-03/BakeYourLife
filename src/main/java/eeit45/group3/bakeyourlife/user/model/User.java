package eeit45.group3.bakeyourlife.user.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

@Entity
@Table(name = "Users")

public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(unique = true)
	private String username;
	private String password;
	private String fullName;
	private String email;
	private String phone;
	private String birth;
	private String gender;
	private String address;

	private String fileName;

	private Blob userImage;

	private Timestamp registerTime;

	@Transient
	MultipartFile productImage;


	public User() {
		super();
	}

	public User(String username, String password, String fullName, String email, String phone, String birth, String gender, String address) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.address = address;
	}

	public User(Integer userId, String username, String password, String fullName, String email, String phone,
				String birth, String gender, String address, String fileName, Blob userImage, Timestamp registerTime, MultipartFile productImage) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.address = address;
		this.fileName = fileName;
		this.userImage = userImage;
		this.registerTime = registerTime;
		this.productImage = productImage;


	}

	public User(String username, String password, String fullName, String email, String phone, String birth,
			String gender, String address, String fileName, Blob userImage,Timestamp registerTime,MultipartFile productImage) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.address = address;
		this.fileName = fileName;
		this.userImage = userImage;
		this.registerTime = registerTime;
		this.productImage = productImage;


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
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Blob getUserImage() {
		return userImage;
	}

	public void setUserImage(Blob userImage) {
		this.userImage = userImage;
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
