package com.dalrun.dto;

public class SearchParam {
	private String choice;
	private String Search;
	private int pageNumber;
	private String grade;
	private String sale;
	private String stock;
	private String order;
	private String delivery;
	private String memId;	
	private String inqState;	// 답변상태
	private String local;	// 대회지역


	private int start;
	private int end;
	
	public SearchParam() {
	}

	public SearchParam(String choice, String search, int pageNumber, String grade, String sale, String stock, String order,
			String delivery, String memId, String inqState, String local, int start, int end) {
		super();
		this.choice = choice;
		Search = search;
		this.pageNumber = pageNumber;
		this.grade = grade;
		this.sale = sale;
		this.stock = stock;
		this.order = order;
		this.delivery = delivery;
		this.memId = memId;
		this.inqState = inqState;
		this.local = local;
		this.start = start;
		this.end = end;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return Search;
	}

	public void setSearch(String search) {
		Search = search;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getInqState() {
		return inqState;
	}

	public void setInqState(String inqState) {
		this.inqState = inqState;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "SearchParam [choice=" + choice + ", Search=" + Search + ", pageNumber=" + pageNumber + ", grade="
				+ grade + ", sale=" + sale + ", stock=" + stock + ", order=" + order + ", delivery=" + delivery
				+ ", memId=" + memId + ", inqState=" + inqState + ", local=" + local + ", start=" + start + ", end="
				+ end + "]";
	}
}
