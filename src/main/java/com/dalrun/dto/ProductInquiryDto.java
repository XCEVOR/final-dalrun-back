package com.dalrun.dto;

public class ProductInquiryDto {

    private int inqSeq;
    private String inqWriter;
    private String inqContent;
    private String inqDate;
    private String productId;
    private String memId;
    
    public ProductInquiryDto() {

    }

    public ProductInquiryDto(int inqSeq, String inqWriter, String inqContent, String inqDate, String productId,
            String memId) {
        super();
        this.inqSeq = inqSeq;
        this.inqWriter = inqWriter;
        this.inqContent = inqContent;
        this.inqDate = inqDate;
        this.productId = productId;
        this.memId = memId;
    }

    public int getInqSeq() {
        return inqSeq;
    }

    public void setInqSeq(int inqSeq) {
        this.inqSeq = inqSeq;
    }

    public String getInqWriter() {
        return inqWriter;
    }

    public void setInqWriter(String inqWriter) {
        this.inqWriter = inqWriter;
    }

    public String getInqContent() {
        return inqContent;
    }

    public void setInqContent(String inqContent) {
        this.inqContent = inqContent;
    }

    public String getInqDate() {
        return inqDate;
    }

    public void setInqDate(String inqDate) {
        this.inqDate = inqDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    @Override
    public String toString() {
        return "ProductInquiryDto [inqSeq=" + inqSeq + ", inqWriter=" + inqWriter + ", inqContent=" + inqContent
                + ", inqDate=" + inqDate + ", productId=" + productId + ", memId=" + memId + "]";
    }
    
    
}
