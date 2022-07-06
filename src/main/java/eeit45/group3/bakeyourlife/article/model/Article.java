package eeit45.group3.bakeyourlife.article.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import org.springframework.web.multipart.MultipartFile;

//@NamedQuery(
//        name = "findAll",
//        query = "SELECT postid,title,date FROM Article "
//)

@Entity
@Table(name = "Article")
public class Article implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="postid")
	private Integer postid;
	//@Column(name="title")
	@Valid
	@NotBlank(message = "標題不可為空")
	private String title;
	@Valid
	@NotBlank(message = "分類不可為空")
	private String type;
	//@Column(name="date")
	@Valid
	@NotNull(message = "日期不可為空")
	private Date date;
	@Valid
	@NotBlank(message = "內容欄不可為空")
	@Lob
	private String content;
	@Lob
	@JsonIgnore
	private byte[] picture;
	@Transient
	private MultipartFile articleImage;
	@Transient
	private String base64;
	private Integer counter;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "article", cascade = CascadeType.ALL)
	private Set<Message> MessageList = new LinkedHashSet<>();
	
	public Article() {
		super();
	}
	
	public Article(Integer postid,String title,String type,Date date,String content,byte[] picture,MultipartFile articleImage,String base64,Integer counter) {
		super();
		this.postid = postid;
		this.title = title;
		this.type = type;
		this.date = date;
		this.content = content;
		this.picture = picture;
		this.articleImage = articleImage;
		this.base64 = base64;
		this.counter = counter;
	}

	

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public MultipartFile getArticleImage() {
		return articleImage;
	}

	public void setArticleImage(MultipartFile articleImage) {
		this.articleImage = articleImage;
	}

	public String getBase64() {
		return new String(this.getPicture());
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}


	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("postid [postid=");
		builder.append(postid);
		builder.append(", title=");
		builder.append(title);
		builder.append(", type=");
		builder.append(type);
		builder.append(", date=");
		builder.append(date);
		builder.append(", content=");
		builder.append(content);
		builder.append(", picture=");
		builder.append(picture);
		builder.append(", counter=");
		builder.append(counter);
		return "Article [postid=" + postid + ", title=" + title + ", type=" + type + ", date=" + date
				+ ", content=" + content + ", picture=" + picture + ", counter=" + counter + 
				"]";
	}

}