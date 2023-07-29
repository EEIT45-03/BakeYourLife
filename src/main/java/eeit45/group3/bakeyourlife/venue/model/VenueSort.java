package eeit45.group3.bakeyourlife.venue.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "VenueSort")
@Component
public class VenueSort implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer venueSortId;

  @Column(nullable = false, unique = true)
  private String sort;

  @JsonBackReference
  @OneToMany(
      cascade = {CascadeType.ALL},
      orphanRemoval = false,
      mappedBy = "venueSort")
  private Set<Venue> venues = new LinkedHashSet<Venue>();

  public VenueSort() {}

  public VenueSort(String sort) {
    this.sort = sort;
  }

  public Integer getVenueSortId() {
    return venueSortId;
  }

  public void setVenueSortId(Integer venueSortId) {
    this.venueSortId = venueSortId;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public Set<Venue> getVenues() {
    return venues;
  }

  public void setVenues(Set<Venue> venues) {
    this.venues = venues;
  }
}
