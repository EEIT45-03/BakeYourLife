package eeit45.group3.bakeyourlife.article.model;

import eeit45.group3.bakeyourlife.user.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="favorite")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(name="use_id")
    private User user;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private  Article article;

    public Favorite() {
    }

    public Favorite(User user, Article article) {
        this.user = user;
        this.article = article;
        this.createdDate = new Date();
    }

    public Favorite(Integer id, User user, Date createdDate, Article article) {
        this.id = id;
        this.user = user;
        this.createdDate = createdDate;
        this.article = article;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
