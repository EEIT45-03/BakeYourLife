package eeit45.group3.bakeyourlife.course.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String summary;
    private String description;
    private Integer price;
    private String image;
    @Transient
    private MultipartFile file;


}
