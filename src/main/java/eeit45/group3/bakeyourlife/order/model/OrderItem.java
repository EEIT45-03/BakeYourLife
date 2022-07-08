package eeit45.group3.bakeyourlife.order.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("order")
public class OrderItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//自增PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemNo;
	
	//商品ID
	private String productNo;
	
	//商品名稱
	private String productName;

	//商品類型
	private String productType;
	
	//單價，不存入資料庫(購物車用)，因為未串接商品，暫時使用
	@Transient
	private Integer price;
	
	//數量 
	private Integer qty;
	
	//小計
	private Integer subTotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orderId")
	private Order order;


	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}


	public Integer getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}
	
	
	
	
	
	
	
	
	
}
