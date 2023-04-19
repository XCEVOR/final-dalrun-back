package com.dalrun.dto;

import java.io.Serializable;

public class ProductDto  implements Serializable{

	private String productId;
	private String productName;
	private String productPrice;
	private String productCategory;
	private String productDescription;
	private String productRegiDate;
	private String productOrigFile;// 상품 원본 사진
	private String productNewFile; // 상품 변경 사진
	private int productStock; // 상품 재고 
	private int productSale; // 판매 여부 [0 - 미판매 / 1- 판매]
	private int productSoldout; // 품절 여부 [0 - 품절x / 1-품절 o ]

	
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}



    public ProductDto(String productId, String productName, String productPrice, String productCategory,
            String productDescription, String productRegiDate, String productOrigFile, String productNewFile,
            int productStock, int productSale, int productSoldout) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productRegiDate = productRegiDate;
        this.productOrigFile = productOrigFile;
        this.productNewFile = productNewFile;
        this.productStock = productStock;
        this.productSale = productSale;
        this.productSoldout = productSoldout;
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



    public String getProductCategory() {
        return productCategory;
    }



    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }



    public String getProductDescription() {
        return productDescription;
    }



    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }



    public String getProductRegiDate() {
        return productRegiDate;
    }



    public void setProductRegiDate(String productRegiDate) {
        this.productRegiDate = productRegiDate;
    }



    public String getProductOrigFile() {
        return productOrigFile;
    }



    public void setProductOrigFile(String productOrigFile) {
        this.productOrigFile = productOrigFile;
    }



    public String getProductNewFile() {
        return productNewFile;
    }



    public void setProductNewFile(String productNewFile) {
        this.productNewFile = productNewFile;
    }



    public int getProductStock() {
        return productStock;
    }



    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }



    public int getProductSale() {
        return productSale;
    }



    public void setProductSale(int productSale) {
        this.productSale = productSale;
    }



    public int getProductSoldout() {
        return productSoldout;
    }



    public void setProductSoldout(int productSoldout) {
        this.productSoldout = productSoldout;
    }



    @Override
    public String toString() {
        return "ProductDto [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
                + ", productCategory=" + productCategory + ", productDescription=" + productDescription
                + ", productRegiDate=" + productRegiDate + ", productOrigFile=" + productOrigFile + ", productNewFile="
                + productNewFile + ", productStock=" + productStock + ", productSale=" + productSale
                + ", productSoldout=" + productSoldout + "]";
    }
	
	
	
}
