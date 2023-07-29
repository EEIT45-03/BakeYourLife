package eeit45.group3.bakeyourlife.coupon.model;


import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Entity
@DiscriminatorValue("discount")
public class DiscountCoupon extends Coupon {

  @DecimalMax(value = "9.9", message = "請填寫介於0.1 到 9.9 之間的有效數字")
  @DecimalMin(value = "0.1", message = "請填寫介於0.1 到 9.9 之間的有效數字")
  private Double discount;

  @Override
  public Integer getDiscountAmount(Integer totalPrice) {
    if (totalPrice >= this.getMinimum()) {
      // 0.1~9.9
      BigDecimal discount = new BigDecimal(this.discount.toString());
      BigDecimal total = new BigDecimal(totalPrice);
      BigDecimal ten = new BigDecimal(10);
      // ten 減 discount
      discount = ten.subtract(discount);
      // discount 除 ten
      discount = discount.divide(ten);
      return total.multiply(discount).setScale(0, RoundingMode.HALF_UP).intValue();
    }
    return 0;
  }

  @Override
  public String getDiscountString() {
    BigDecimal b = new BigDecimal(this.discount);
    return "滿" + this.getMinimum() + "元打" + b.stripTrailingZeros().toPlainString() + "折";
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }
}
