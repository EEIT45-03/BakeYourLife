package eeit45.group3.bakeyourlife.coupon.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("deduct")
public class DeductCoupon extends Coupon{

    //扣減金額
    private Integer deductAmount;


    @Override
    Integer getDiscountAmount(Integer totalPrice) {
        if(totalPrice >= this.getMinimum()){
            return deductAmount;
        }
        return 0;
    }

    @Override
    String getDiscountString() {
        return "NT$" + deductAmount;
    }

    public Integer getDeductAmount() {
        return deductAmount;
    }

    public void setDeductAmount(Integer deductAmount) {
        this.deductAmount = deductAmount;
    }
}
