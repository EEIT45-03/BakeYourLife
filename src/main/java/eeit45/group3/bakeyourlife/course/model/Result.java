//package eeit45.group3.bakeyourlife.course.model;
//
//import eeit45.group3.bakeyourlife.good.model.Goods;
//import eeit45.group3.bakeyourlife.user.model.User;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.persistence.*;
//
//public class Result {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long resultId;
//    private String resultTitle;
//    private String resultComment;
//    private String resultImageUrl;
//    @Transient
//    private MultipartFile resultFile;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "fk_user_id")
//    private User user;
//
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "fk_register")
////    private Register register;
//
//    public Result(){}
//
//    public Result(Long resultId, String resultTitle, String resultComment, String resultImageUrl, MultipartFile resultFile, User user) {
//        this.resultId = resultId;
//        this.resultTitle = resultTitle;
//        this.resultComment = resultComment;
//        this.resultImageUrl = resultImageUrl;
//        this.resultFile = resultFile;
//        this.user = user;
//
//    }
//
//    public Long getResultId() {
//        return resultId;
//    }
//
//    public void setResultId(Long resultId) {
//        this.resultId = resultId;
//    }
//
//    public String getResultTitle() {
//        return resultTitle;
//    }
//
//    public void setResultTitle(String resultTitle) {
//        this.resultTitle = resultTitle;
//    }
//
//    public String getResultComment() {
//        return resultComment;
//    }
//
//    public void setResultComment(String resultComment) {
//        this.resultComment = resultComment;
//    }
//
//    public String getResultImageUrl() {
//        return resultImageUrl;
//    }
//
//    public void setResultImageUrl(String resultImageUrl) {
//        this.resultImageUrl = resultImageUrl;
//    }
//
//    public MultipartFile getResultFile() {
//        return resultFile;
//    }
//
//    public void setResultFile(MultipartFile resultFile) {
//        this.resultFile = resultFile;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//
//}
