package eeit45.group3.bakeyourlife.venue.dto;

import eeit45.group3.bakeyourlife.venue.model.VenueSort;

public class VenueTop3 {

  private Integer venueId;

  private String venueName;

  private Integer personMax;

  private Integer hrPrice;

  private String picture;

  private String notes;

  private VenueSort venueSort;

  private Long sum;

  public Integer getVenueId() {
    return venueId;
  }

  public void setVenueId(Integer venueId) {
    this.venueId = venueId;
  }

  public String getVenueName() {
    return venueName;
  }

  public void setVenueName(String venueName) {
    this.venueName = venueName;
  }

  public Integer getPersonMax() {
    return personMax;
  }

  public void setPersonMax(Integer personMax) {
    this.personMax = personMax;
  }

  public Integer getHrPrice() {
    return hrPrice;
  }

  public void setHrPrice(Integer hrPrice) {
    this.hrPrice = hrPrice;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public VenueSort getVenueSort() {
    return venueSort;
  }

  public void setVenueSort(VenueSort venueSort) {
    this.venueSort = venueSort;
  }

  public Long getSum() {
    return sum;
  }

  public void setSum(Long sum) {
    this.sum = sum;
  }
}
