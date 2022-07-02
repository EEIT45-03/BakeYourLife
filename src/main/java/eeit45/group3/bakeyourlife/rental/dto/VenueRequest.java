package eeit45.group3.bakeyourlife.rental.dto;

public class VenueRequest {


    private Integer venueId;

    private String venueName;

    private Integer personMax;


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
}
