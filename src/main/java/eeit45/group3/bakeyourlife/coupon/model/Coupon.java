package eeit45.group3.bakeyourlife.coupon.model;

import com.fasterxml.jackson.annotation.*;
import eeit45.group3.bakeyourlife.order.model.Order;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "DISCRIMINATOR",
    discriminatorType = DiscriminatorType.STRING,
    length = 30)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonIgnoreProperties("orderList")
@JsonSubTypes({
  @JsonSubTypes.Type(value = DeductCoupon.class, name = "deduct"),
  @JsonSubTypes.Type(value = DiscountCoupon.class, name = "discount"),
})
public abstract class Coupon implements Serializable {
  @Id // 折扣卷代碼
  @Column(unique = true)
  @NotBlank
  private String code;
  // 名稱
  @NotBlank private String name;
  // 開始時間
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd'T'HH:mm")
  @NotNull
  private Date startDate;
  // 結束時間
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd'T'HH:mm")
  @Future(message = "結束時間不能是過去日期")
  @NotNull
  private Date endDate;
  // 最低消費金額
  @NotNull private Integer minimum;
  // 可使用數量
  @NotNull private Integer maxQuantity;
  // 已使用數量
  private Integer usedQuantity = 0;

  private String discountString;

  private String state;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "coupon")
  private Set<Order> orderList = new LinkedHashSet<>();

  // 取得扣減金額
  public Integer getDiscountAmount(Integer totalPrice) {
    return null;
  }

  // 取得折扣額度，NT$100/9.9折
  @JsonGetter
  public String getDiscountString() {
    return null;
  }

  @JsonGetter
  public String getState() {
    Date now = new Date();

    if (now.before(startDate)) { // 如果現在比開始時間早
      return "尚未開始";
    } else if (now.after(endDate)) { // 如果現在比結束時間遠
      return "已結束";
    } else if (now.after(startDate)) { // 如果現在比開始時間遠
      return "進行中";
    }
    return null;
  }

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

  public Set<Order> getOrderList() {
    return orderList;
  }

  public void setOrderList(Set<Order> orderList) {
    this.orderList = orderList;
  }
}
