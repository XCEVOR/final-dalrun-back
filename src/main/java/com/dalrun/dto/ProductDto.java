package com.dalrun.dto;

import java.io.Serializable;

public class ProductDto  implements Serializable{

	private String productId;
	private String productCode;
	private String productCategory;
	private String productBrand;
	private String productName;
	private String productPrice;
	private String productColor;
	private String productSize;
	private String productDescription;
	private String productRegiDate;
	private int productView;
	private int productLike;
	private int productRecomm;
	private int productStock; // 상품 재고 
	private int productSale; // 판매 여부 [0 - 품절 / 1- 판매]
	private String productOrigFile;// 상품 원본 사진
	private String productNewFile; // 상품 변경 사진
	private int orderCnt;

	public ProductDto() {
		// TODO Auto-generated constructor stub
	}
	
	

    public ProductDto(String productCode, String productColor, String productSize) {
        super();
        this.productCode = productCode;
        this.productColor = productColor;
        this.productSize = productSize;
    }
    

    public ProductDto(String productId, String productCode, String productCategory, String productBrand,
            String productName, String productPrice, String productColor, String productSize, String productDescription,
            String productRegiDate, int productView, int productLike, int productRecomm, int productStock,
            int productSale, String productOrigFile, String productNewFile, int orderCnt) {
        super();
        this.productId = productId;
        this.productCode = productCode;
        this.productCategory = productCategory;
        this.productBrand = productBrand;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.productSize = productSize;
        this.productDescription = productDescription;
        this.productRegiDate = productRegiDate;
        this.productView = productView;
        this.productLike = productLike;
        this.productRecomm = productRecomm;
        this.productStock = productStock;
        this.productSale = productSale;
        this.productOrigFile = productOrigFile;
        this.productNewFile = productNewFile;
        this.orderCnt = orderCnt;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
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

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
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

    public int getProductView() {
        return productView;
    }

    public void setProductView(int productView) {
        this.productView = productView;
    }

    public int getProductLike() {
        return productLike;
    }

    public void setProductLike(int productLike) {
        this.productLike = productLike;
    }

    public int getProductRecomm() {
        return productRecomm;
    }

    public void setProductRecomm(int productRecomm) {
        this.productRecomm = productRecomm;
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

    public int getOrderCnt() {
		return orderCnt;
	}

	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productCode=" + productCode + ", productCategory="
				+ productCategory + ", productBrand=" + productBrand + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productColor=" + productColor + ", productSize=" + productSize
				+ ", productDescription=" + productDescription + ", productRegiDate=" + productRegiDate
				+ ", productView=" + productView + ", productLike=" + productLike + ", productRecomm=" + productRecomm
				+ ", productStock=" + productStock + ", productSale=" + productSale + ", productOrigFile="
				+ productOrigFile + ", productNewFile=" + productNewFile + ", orderCnt=" + orderCnt + "]";
	}



	
}
