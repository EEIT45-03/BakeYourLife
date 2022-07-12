//package eeit45.group3.bakeyourlife.course.model;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Arrays;
//
//@Entity
//@Table(name = "CourseType")
//public class CourseType implements Serializable {
//
//    /**
//     *
//     */
//    private static final long serialVersionUID = 1L;
//
//    //課程代號
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer courseId;
//
//    //課程名稱
//    @Column(name = "courseName",columnDefinition = "nvarchar(20) not null")
//    private String courseName;
//    //課程分類
//    @Column(name = "courseType",columnDefinition = "nvarchar(20) not null")
//    private String courseType;
//    //課程簡介
//    @Column(name = "courseMemo",columnDefinition = "nvarchar(200) not null")
//    private String courseMemo;
//    //課程說明
//    @Column(name = "courseDesc",columnDefinition = "nvarchar(MAX) not null")
//    private String courseDescription;
//    //課程時數
//    @Column(nullable = false)
//    private Integer courseHours;
//
//    //Image related
//    @Lob
//    private byte[] courseImg;
//    @Transient
//    private String base64;
//    @Transient
//    MultipartFile productImage;
//
//    //Teacher
//    @Column(name = "teacherId",columnDefinition = "int not null")
//    private Integer teacherId;
//
//    @Column(name = "teacherName",columnDefinition = "nvarchar(MAX) not null")
//    private String teacherName;
//
//    @Column(name = "teacherDesc",columnDefinition = "nvarchar(MAX) not null")
//    private String teacherDescription;
//
//
//
//    public CourseType(Integer courseId, String courseName, String courseType, String courseMemo, String courseDescription, Integer courseHours, byte[] courseImg, String base64, MultipartFile productImage, Integer teacherId, String teacherName, String teacherDescription) {
//        this.courseId = courseId;
//        this.courseName = courseName;
//        this.courseType = courseType;
//        this.courseMemo = courseMemo;
//        this.courseDescription = courseDescription;
//        this.courseHours = courseHours;
//        this.courseImg = courseImg;
//        this.base64 = base64;
//        this.productImage = productImage;
//        this.teacherId = teacherId;
//        this.teacherName = teacherName;
//        this.teacherDescription = teacherDescription;
//    }
//
//    public CourseType() {
//
//    }
//
//
//    public Integer getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Integer courseId) {
//        this.courseId = courseId;
//    }
//
//    public String getCourseName() {
//        return courseName;
//    }
//
//    public void setCourseName(String courseName) {
//        this.courseName = courseName;
//    }
//
//    public String getCourseType() {
//        return courseType;
//    }
//
//    public void setCourseType(String courseType) {
//        this.courseType = courseType;
//    }
//
//    public String getCourseMemo() {
//        return courseMemo;
//    }
//
//    public void setCourseMemo(String courseMemo) {
//        this.courseMemo = courseMemo;
//    }
//
//    public String getCourseDescription() {
//        return courseDescription;
//    }
//
//    public void setCourseDescription(String courseDescription) {
//        this.courseDescription = courseDescription;
//    }
//
//    public Integer getCourseHours() {
//        return courseHours;
//    }
//
//    public void setCourseHours(Integer courseHours) {
//        this.courseHours = courseHours;
//    }
//
//    public byte[] getCourseImg() {
//        return courseImg;
//    }
//
//    public void setCourseImg(byte[] courseImg) {
//        this.courseImg = courseImg;
//    }
//
//    public String getBase64() {
//        return base64;
//    }
//
//    public void setBase64(String base64) {
//        this.base64 = base64;
//    }
//
//    public MultipartFile getProductImage() {
//        return productImage;
//    }
//
//    public void setProductImage(MultipartFile productImage) {
//        this.productImage = productImage;
//    }
//
//    public Integer getTeacherId() {
//        return teacherId;
//    }
//
//    public void setTeacherId(Integer teacherId) {
//        this.teacherId = teacherId;
//    }
//
//    public String getTeacherName() {
//        return teacherName;
//    }
//
//    public void setTeacherName(String teacherName) {
//        this.teacherName = teacherName;
//    }
//
//    public String getTeacherDescription() {
//        return teacherDescription;
//    }
//
//    public void setTeacherDescription(String teacherDescription) {
//        this.teacherDescription = teacherDescription;
//    }
//
//    @Override
//    public String toString() {
//        return "CourseType{" +
//                "courseId=" + courseId +
//                ", courseName='" + courseName + '\'' +
//                ", courseType='" + courseType + '\'' +
//                ", courseMemo='" + courseMemo + '\'' +
//                ", courseDescription='" + courseDescription + '\'' +
//                ", courseHours=" + courseHours +
//                ", courseImg=" + Arrays.toString(courseImg) +
//                ", base64='" + base64 + '\'' +
//                ", productImage=" + productImage +
//                ", teacherId=" + teacherId +
//                ", teacherName='" + teacherName + '\'' +
//                ", teacherDescription='" + teacherDescription + '\'' +
//                '}';
//    }
//}
