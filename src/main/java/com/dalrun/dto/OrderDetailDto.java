package com.dalrun.dto;

public class OrderDetailDto {
	private long orderNumber;
	private String productId;
	private String productName;
	private String productPrice;	
	private String productQuantity;	// 각 상품의 주문 수량
	private String option1;	// 옵션1 : 색상
	private String option2;	// 옵션2 : 사이즈
	
	public OrderDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetailDto(long orderNumber, String productId, String productName, String productPrice,
			String productQuantity, String option1, String option2) {
		super();
		this.orderNumber = orderNumber;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.option1 = option1;
		this.option2 = option2;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	@Override
	public String toString() {
		return "OrderDetailDto [orderNumber=" + orderNumber + ", productId=" + productId + ", productName="
				+ productName + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", option1="
				+ option1 + ", option2=" + option2 + "]";
	}
}
