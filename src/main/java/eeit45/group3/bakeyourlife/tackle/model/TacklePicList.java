package eeit45.group3.bakeyourlife.tackle.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TacklePicList")
@Component
public class TacklePicList implements Serializable {

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @Column(name = "picListId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "picture", nullable = false, unique = true)
    private String picture;

    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="FK_tackleId", referencedColumnName = "tackleId", nullable = false)
    private Tackle tackle;

    public TacklePicList() {
    }

    public TacklePicList(String picture, Tackle tackle) {
        this.picture = picture;
        this.tackle = tackle;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Tackle getTackle() {
        return tackle;
    }

    public void setTackle(Tackle tackle) {
        this.tackle = tackle;
    }
}
