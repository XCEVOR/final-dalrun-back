package com.dalrun.dto;

import java.io.Serializable;

public class OrderDto implements Serializable{
	
    private long orderNumber;
    private String memId;
    private String orderName;
    private String orderAddress;
    private String orderPhone;
    private String orderRequirment; // 주문 요청 사항
    private String orderTotalprice; // 총 구매 금액
    private String orderDate;
    private int orderQuantity;
    private int orderState; // 주문 상태 [0 - 주문완료 / 1 - 환불 / 2 - 취소 / 3 - 반품]
    private int deliveryState; // 배송상태 [0 - 배송준비 / 1 - 배송중 / 2 - 배송완료]
    private String productId;   // 주문한 상품 아이디
	private String productName;
	private String productPrice;	
	private String productQuantity;	// 각 상품의 주문 수량
	private String option1;	// 옵션1 : 색상
	private String option2;	// 옵션2 : 사이즈
	
	public OrderDto() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDto(long orderNumber, String memId, String orderName, String orderAddress, String orderPhone,
			String orderRequirment, String orderTotalprice, String orderDate, int orderQuantity, int orderState,
			int deliveryState, String productId, String productName, String productPrice, String productQuantity,
			String option1, String option2) {
		super();
		this.orderNumber = orderNumber;
		this.memId = memId;
		this.orderName = orderName;
		this.orderAddress = orderAddress;
		this.orderPhone = orderPhone;
		this.orderRequirment = orderRequirment;
		this.orderTotalprice = orderTotalprice;
		this.orderDate = orderDate;
		this.orderQuantity = orderQuantity;
		this.orderState = orderState;
		this.deliveryState = deliveryState;
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
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public String getOrderRequirment() {
		return orderRequirment;
	}
	public void setOrderRequirment(String orderRequirment) {
		this.orderRequirment = orderRequirment;
	}
	public String getOrderTotalprice() {
		return orderTotalprice;
	}
	public void setOrderTotalprice(String orderTotalprice) {
		this.orderTotalprice = orderTotalprice;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public int getDeliveryState() {
		return deliveryState;
	}
	public void setDeliveryState(int deliveryState) {
		this.deliveryState = deliveryState;
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
		return "OrderDto [orderNumber=" + orderNumber + ", memId=" + memId + ", orderName=" + orderName
				+ ", orderAddress=" + orderAddress + ", orderPhone=" + orderPhone + ", orderRequirment="
				+ orderRequirment + ", orderTotalprice=" + orderTotalprice + ", orderDate=" + orderDate
				+ ", orderQuantity=" + orderQuantity + ", orderState=" + orderState + ", deliveryState=" + deliveryState
				+ ", productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", option1=" + option1 + ", option2=" + option2 + "]";
	}

	
}
