package com.dalrun.dto;

public class DashboardData {
	private int orderCnt;         // 주문 수
    private int orderSummaryCnt;     // 취소/환불/반품 수
    private int stockoutCnt;         // 재고 부족 수
    private int inquiryWaitingCnt;   // 문의 대기 수
    private int orderTotalprice;	// 매출액
    private int accountCnt;		// 가입자 수
    private int reviewCnt;		// 리뷰 수
    private String weekDate;
    
    public DashboardData() {
		// TODO Auto-generated constructor stub
	}

	public DashboardData(int orderCnt, int orderSummaryCnt, int stockoutCnt, int inquiryWaitingCnt, int orderTotalprice,
			int accountCnt, int reviewCnt, String weekDate) {
		super();
		this.orderCnt = orderCnt;
		this.orderSummaryCnt = orderSummaryCnt;
		this.stockoutCnt = stockoutCnt;
		this.inquiryWaitingCnt = inquiryWaitingCnt;
		this.orderTotalprice = orderTotalprice;
		this.accountCnt = accountCnt;
		this.reviewCnt = reviewCnt;
		this.weekDate = weekDate;
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

	public int getOrderTotalprice() {
		return orderTotalprice;
	}

	public void setOrderTotalprice(int orderTotalprice) {
		this.orderTotalprice = orderTotalprice;
	}

	public int getAccountCnt() {
		return accountCnt;
	}

	public void setAccountCnt(int accountCnt) {
		this.accountCnt = accountCnt;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public String getWeekDate() {
		return weekDate;
	}

	public void setWeekDate(String weekDate) {
		this.weekDate = weekDate;
	}

	@Override
	public String toString() {
		return "DashboardData [orderCnt=" + orderCnt + ", orderSummaryCnt=" + orderSummaryCnt + ", stockoutCnt="
				+ stockoutCnt + ", inquiryWaitingCnt=" + inquiryWaitingCnt + ", orderTotalprice=" + orderTotalprice
				+ ", accountCnt=" + accountCnt + ", reviewCnt=" + reviewCnt + ", weekDate=" + weekDate + "]";
	}
}
