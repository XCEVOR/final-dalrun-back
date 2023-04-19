package com.dalrun.dto;

import java.io.Serializable;

public class OrderDto implements Serializable{
	
    private int orderSeq;
	private String memId;
	private String oderName;
	private String orderAddress;
	private String orderPhone;
	private String orderRequirment; // 주문 요청 사항
	private String orderTotalprice; // 총 구매 금액
	private String orderDate;
	private int orderQuantity;
	private String orderState; // 주문 상태
	private String deliveryState; // 배송상태
	
	public OrderDto() {
		// TODO Auto-generated constructor stub
	}

    public OrderDto(int orderSeq, String memId, String oderName, String orderAddress, String orderPhone,
            String orderRequirment, String orderTotalprice, String orderDate, int orderQuantity, String orderState,
            String deliveryState) {
        super();
        this.orderSeq = orderSeq;
        this.memId = memId;
        this.oderName = oderName;
        this.orderAddress = orderAddress;
        this.orderPhone = orderPhone;
        this.orderRequirment = orderRequirment;
        this.orderTotalprice = orderTotalprice;
        this.orderDate = orderDate;
        this.orderQuantity = orderQuantity;
        this.orderState = orderState;
        this.deliveryState = deliveryState;
    }

    public int getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(int orderSeq) {
        this.orderSeq = orderSeq;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getOderName() {
        return oderName;
    }

    public void setOderName(String oderName) {
        this.oderName = oderName;
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

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    @Override
    public String toString() {
        return "OrderDto [orderSeq=" + orderSeq + ", memId=" + memId + ", oderName=" + oderName + ", orderAddress="
                + orderAddress + ", orderPhone=" + orderPhone + ", orderRequirment=" + orderRequirment
                + ", orderTotalprice=" + orderTotalprice + ", orderDate=" + orderDate + ", orderQuantity="
                + orderQuantity + ", orderState=" + orderState + ", deliveryState=" + deliveryState + "]";
    }

	
	

}
