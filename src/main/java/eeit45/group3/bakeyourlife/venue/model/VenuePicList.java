package eeit45.group3.bakeyourlife.venue.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VenuePicList")
@Component
public class VenuePicList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "picListId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "picture", nullable = false, unique = true)
    private String picture;

//    @Transient
//    private MultipartFile venueImage;

    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="FK_venueId", referencedColumnName = "venueId", nullable = false)
    private Venue venue;

    public VenuePicList(String picture, Venue venue) {
        this.picture = picture;
        this.venue = venue;
    }

    public VenuePicList() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer pivId) {
        this.Id = pivId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
