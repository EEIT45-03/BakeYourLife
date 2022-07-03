package eeit45.group3.bakeyourlife.order.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Deprecated
public class OrderRequest {
	private Integer userId;
	private String address;
	private String orderType;
	private Integer shippingFee;
	private String orderStatus;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date shipDate;
	
	private String[] productNo;
	private String[] productName;
	private Integer[] qty;
	private Integer[] subTotal;
	

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Integer getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(Integer shippingFee) {
		this.shippingFee = shippingFee;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	public String[] getProductNo() {
		return productNo;
	}
	public void setProductNo(String[] productNo) {
		this.productNo = productNo;
	}
	public String[] getProductName() {
		return productName;
	}
	public void setProductName(String[] productName) {
		this.productName = productName;
	}
	public Integer[] getQty() {
		return qty;
	}
	public void setQty(Integer[] qty) {
		this.qty = qty;
	}
	public Integer[] getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Integer[] subTotal) {
		this.subTotal = subTotal;
	}
	
}
