package eeit45.group3.bakeyourlife.tackle.dto;

import java.util.List;

public class TackleRequest {

    private String tackleName;

    private  String specification;

    private Integer dayPrice;

    private Integer damages;

    private Integer max;

    private Integer sortId;

    private  String notes;

    private List<String> base64;

    public TackleRequest() {
    }

    public TackleRequest(String tackleName, String specification, Integer dayPrice, Integer damages, Integer max, Integer sortId, String notes, List<String> base64) {
        this.tackleName = tackleName;
        this.specification = specification;
        this.dayPrice = dayPrice;
        this.damages = damages;
        this.max = max;
        this.sortId = sortId;
        this.notes = notes;
        this.base64 = base64;
    }

    public String getTackleName() {
        return tackleName;
    }

    public void setTackleName(String tackleName) {
        this.tackleName = tackleName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Integer getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(Integer dayPrice) {
        this.dayPrice = dayPrice;
    }

    public Integer getDamages() {
        return damages;
    }

    public void setDamages(Integer damages) {
        this.damages = damages;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<String> getBase64() {
        return base64;
    }

    public void setBase64(List<String> base64) {
        this.base64 = base64;
    }
}
