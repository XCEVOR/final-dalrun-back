package com.dalrun.dto;

public class SearchParam {
	private String choice;
	private String Search;
	private int pageNumber;
	private String grade;
	private int sale;
	private int stock;
	
	private int start;
	private int end;
	
	public SearchParam() {
	}

	public SearchParam(String choice, String search, int pageNumber, String grade, int sale, int stock, int start,
			int end) {
		super();
		this.choice = choice;
		Search = search;
		this.pageNumber = pageNumber;
		this.grade = grade;
		this.sale = sale;
		this.stock = stock;
		this.start = start;
		this.end = end;
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

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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
				+ grade + ", sale=" + sale + ", stock=" + stock + ", start=" + start + ", end=" + end + "]";
	}
}
