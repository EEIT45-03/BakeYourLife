package eeit45.group3.bakeyourlife.order.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalesRecord implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String productNo;

  private Integer productId;

  private Date salesDate;

  private Integer salesQty;

  private Integer salesSubTotal;

  private Integer farmerId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getSalesSubTotal() {
    return salesSubTotal;
  }

  public void setSalesSubTotal(Integer salesSubTotal) {
    this.salesSubTotal = salesSubTotal;
  }

  public String getProductNo() {
    return productNo;
  }

  public void setProductNo(String productNo) {
    this.productNo = productNo;
  }

  public Date getSalesDate() {
    return salesDate;
  }

  public void setSalesDate(Date salesDate) {
    this.salesDate = salesDate;
  }

  public Integer getSalesQty() {
    return salesQty;
  }

  public void setSalesQty(Integer salesQty) {
    this.salesQty = salesQty;
  }

  public Integer getFarmerId() {
    return farmerId;
  }

  public void setFarmerId(Integer farmerId) {
    this.farmerId = farmerId;
  }
}
