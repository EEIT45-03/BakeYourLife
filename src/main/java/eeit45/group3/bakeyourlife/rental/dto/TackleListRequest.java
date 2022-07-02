package eeit45.group3.bakeyourlife.rental.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import eeit45.group3.bakeyourlife.rental.model.Rental;

public class TackleListRequest {


    private String tackleListNo;

    private String tackleName;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date lendTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date returnTime;

    private Integer quantity;

    private Integer price;

    private Rental rental;

    public TackleListRequest() {
    }

    public TackleListRequest(Rental rental) {
        this.rental = rental;
    }

    public Rental getRental() {
        return rental;
    }


    public void setRental(Rental rental) {
        this.rental = rental;
    }


    public String getTackleListNo() {
        return tackleListNo;
    }

    public void setTackleListNo(String tackleListNo) {
        this.tackleListNo = tackleListNo;
    }

    public String getTackleName() {
        return tackleName;
    }

    public void setTackleName(String tackleName) {
        this.tackleName = tackleName;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
