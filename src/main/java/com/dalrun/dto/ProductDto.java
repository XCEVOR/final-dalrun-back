package com.dalrun.dto;

import java.io.Serializable;

public class ProductDto  implements Serializable{

	private String id;
	private String name;
	private String price;
	private String category;
	private String content; 
	private String originalfile;// 상품 원본 사진
	private String newfile; // 상품 변경 사진
	private int stock; // 상품 재고 
	private int sale; // 판매 여부 [0 - 미판매 / 1- 판매]
	private int soldout; // 품절 여부 [0 - 품절x / 1-품절 o ]
	
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}


	public ProductDto(String id, String name, String price, String category, String content, String originalfile,
			String newfile, int stock, int sale, int soldout) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.content = content;
		this.originalfile = originalfile;
		this.newfile = newfile;
		this.stock = stock;
		this.sale = sale;
		this.soldout = soldout;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getOriginalfile() {
		return originalfile;
	}


	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}


	public String getNewfile() {
		return newfile;
	}


	public void setNewfile(String newfile) {
		this.newfile = newfile;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getSale() {
		return sale;
	}


	public void setSale(int sale) {
		this.sale = sale;
	}


	public int getSoldout() {
		return soldout;
	}


	public void setSoldout(int soldout) {
		this.soldout = soldout;
	}


	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", content="
				+ content + ", originalfile=" + originalfile + ", newfile=" + newfile + ", stock=" + stock + ", sale="
				+ sale + ", soldout=" + soldout + "]";
	}
	
	
	
}
