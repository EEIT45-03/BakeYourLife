package eeit45.group3.bakeyourlife.venue.dto;

import java.util.List;

public class text {

    private String venueName;

    private Integer personMax;

    private Integer hrPrice;

    private String notes;

    private String sort;

    private List<String> base64;

    public text(String venueName, Integer personMax, Integer hrPrice, String notes, String sort, List<String> base64) {
        this.venueName = venueName;
        this.personMax = personMax;
        this.hrPrice = hrPrice;
        this.notes = notes;
        this.sort = sort;
        this.base64 = base64;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<String> getBase64() {
        return base64;
    }

    public void setBase64(List<String> base64) {
        this.base64 = base64;
    }
}
