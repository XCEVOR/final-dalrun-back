package com.dalrun.dto;

public class DashboardData {
	private int orderCnt;         // 주문 수
    private int orderSummaryCnt;     // 취소/환불/반품 수
    private int stockoutCnt;         // 재고 부족 수
    private int inquiryWaitingCnt;   // 문의 대기 수
    
    public DashboardData() {
		// TODO Auto-generated constructor stub
	}

	public DashboardData(int orderCnt, int orderSummaryCnt, int stockoutCnt, int inquiryWaitingCnt) {
		super();
		this.orderCnt = orderCnt;
		this.orderSummaryCnt = orderSummaryCnt;
		this.stockoutCnt = stockoutCnt;
		this.inquiryWaitingCnt = inquiryWaitingCnt;
	}

	public int getOrderCnt() {
		return orderCnt;
	}

	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}

	public int getOrderSummaryCnt() {
		return orderSummaryCnt;
	}

	public void setOrderSummaryCnt(int orderSummaryCnt) {
		this.orderSummaryCnt = orderSummaryCnt;
	}

	public int getStockoutCnt() {
		return stockoutCnt;
	}

	public void setStockoutCnt(int stockoutCnt) {
		this.stockoutCnt = stockoutCnt;
	}

	public int getInquiryWaitingCnt() {
		return inquiryWaitingCnt;
	}

	public void setInquiryWaitingCnt(int inquiryWaitingCnt) {
		this.inquiryWaitingCnt = inquiryWaitingCnt;
	}

	@Override
	public String toString() {
		return "DashboardData [orderCnt=" + orderCnt + ", orderSummaryCnt=" + orderSummaryCnt + ", stockoutCnt="
				+ stockoutCnt + ", inquiryWaitingCnt=" + inquiryWaitingCnt + "]";
	}
}
