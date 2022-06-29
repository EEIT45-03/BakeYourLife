package eeit45.group3.bakeyourlife.coupon.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR", discriminatorType = DiscriminatorType.STRING, length = 30)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DeductCoupon.class,name = "deduct"),
        @JsonSubTypes.Type(value = DiscountCoupon.class,name = "discount"),
})
public abstract class Coupon {
    @Id//折扣卷代碼
    @Column(unique = true)
    private String code;
    //名稱
    private String name;
    //開始時間
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd'T'HH:mm")
//    @DateTimeFormat(pattern="")
    private Date startDate;
    //結束時間
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd'T'HH:mm")
//    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date endDate;
    //最低消費金額
    private Integer minimum;
    //可使用數量
    private Integer maxQuantity;
    //已使用數量
    private Integer usedQuantity = 0;


    //取得扣減金額
    abstract Integer getDiscountAmount(Integer totalPrice);

    //取得折扣額度，NT$100/9.9折
    @JsonGetter
    abstract String getDiscountString();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(Integer maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public Integer getUsedQuantity() {
        return usedQuantity;
    }

    public void setUsedQuantity(Integer usedQuantity) {
        this.usedQuantity = usedQuantity;
    }
}
