package eeit45.group3.bakeyourlife.productcomment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.user.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ProductComment")
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_product_id")
    private FarmerProductBean farmerProductBean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private String commentContent;

    private Integer star;

    public ProductComment() {
    }

    public ProductComment(Integer productCommentId, FarmerProductBean farmerProductBean, User user, Date time, String commentContent, Integer star) {
        this.productCommentId = productCommentId;
        this.farmerProductBean = farmerProductBean;
        this.user = user;
        this.time = time;
        this.commentContent = commentContent;
        this.star = star;
    }

    public Integer getProductCommentId() {
        return productCommentId;
    }

    public void setProductCommentId(Integer productCommentId) {
        this.productCommentId = productCommentId;
    }

    public FarmerProductBean getFarmerProductBean() {
        return farmerProductBean;
    }

    public void setFarmerProductBean(FarmerProductBean farmerProductBean) {
        this.farmerProductBean = farmerProductBean;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}
