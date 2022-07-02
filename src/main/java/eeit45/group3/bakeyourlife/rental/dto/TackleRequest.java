package eeit45.group3.bakeyourlife.rental.dto;

public class TackleRequest {


	private static final long serialVersionUID = 1L;

	private Integer tackleId;
	private String tackleName;

	private String productModel;

	private String specification;

	private byte[] picture;

	private Integer dayPrice;

	private Integer max;


	public TackleRequest() {
	}
	public Integer getTackleId() {
		return tackleId;
	}

	public void setTackleId(Integer tackleId) {
		this.tackleId = tackleId;
	}

	public String getTackleName() {
		return tackleName;
	}

	public void setTackleName(String tackleName) {
		this.tackleName = tackleName;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Integer getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(Integer dayPrice) {
		this.dayPrice = dayPrice;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}


	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}


	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

}
