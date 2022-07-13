package eeit45.group3.bakeyourlife.venue.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VenuePic")
@Component
public class VenuePic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pictureId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pivId;

    @Column(name = "picture", nullable = false, unique = true)
    private String picture;

    @Transient
    private MultipartFile venueImage;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="FK_venueId", referencedColumnName = "venueId", nullable = false)
    private Venue venue;

    public VenuePic(String picture, Venue venue) {
        this.picture = picture;
        this.venue = venue;
    }

    public VenuePic() {

    }

    public Integer getPivId() {
        return pivId;
    }

    public void setPivId(Integer pivId) {
        this.pivId = pivId;
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
