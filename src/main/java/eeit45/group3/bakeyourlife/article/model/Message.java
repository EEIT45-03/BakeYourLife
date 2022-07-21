package eeit45.group3.bakeyourlife.article.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Message")
@JsonIgnoreProperties("article")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

//    private String userName;
    private String message;

    private Date dateTime;

    //    @Lob
//    private byte[] image;
    private String imageUrl;
    @Transient
    @Nullable
    private MultipartFile messageImage;
//    @Transient
//    private String base64Message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postid")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "user_Id",referencedColumnName = "userId", nullable = false)
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message(Integer messageId, String userName, String message, Date dateTime, byte[] image, MultipartFile messageImage,
                   String base64Message) {
        this.messageId = messageId;
//        this.userName = userName;
        this.message = message;
        this.dateTime = dateTime;
        //this.image = image;
        this.messageImage = messageImage;
        //this.base64Message = base64Message;
    }

    public Message() {

    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        ;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }

    public MultipartFile getMessageImage() {
        return messageImage;
    }

    public void setMessageImage(MultipartFile messageImage) {
        this.messageImage = messageImage;
    }

    }
//    public String getBase64Message() {
//        return base64Message;
//    }
//
//    public void setBase64Message(String base64Message) {
//        this.base64Message = base64Message;
//    }
//}

