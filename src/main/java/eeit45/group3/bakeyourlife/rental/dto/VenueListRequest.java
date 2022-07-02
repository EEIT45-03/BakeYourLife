package eeit45.group3.bakeyourlife.rental.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import eeit45.group3.bakeyourlife.rental.model.Rental;

public class VenueListRequest {

    private String venueListNo;

    private String className;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date lendTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date returnTime;

    private Integer person;

    private Integer price;

    private Rental rental;

    public VenueListRequest() {
    }

    public VenueListRequest(Rental rental) {
        this.rental = rental;
    }


    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public String getVenueListNo() {
        return venueListNo;
    }

    public void setVenueListNo(String venueListNo) {
        this.venueListNo = venueListNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
