package com.dalrun.dto;

public class ProductInquiryDto {

    private int inqSeq;
    private int inqSubseq;
    private int inqRef;
    private int inqDepth;
    private String inqWriter;
    private String inqTitle;
    private String inqContent;
    private String inqDate;
    private String productId;
    private String memId;
    private String productCode;
    private int replyCnt;
    
    public ProductInquiryDto() {

    }

    public ProductInquiryDto(int inqSeq, int inqSubseq, int inqRef, int inqDepth, String inqWriter, String inqTitle,
            String inqContent, String inqDate, String productId, String memId, String productCode, int replyCnt) {
        super();
        this.inqSeq = inqSeq;
        this.inqSubseq = inqSubseq;
        this.inqRef = inqRef;
        this.inqDepth = inqDepth;
        this.inqWriter = inqWriter;
        this.inqTitle = inqTitle;
        this.inqContent = inqContent;
        this.inqDate = inqDate;
        this.productId = productId;
        this.memId = memId;
        this.productCode = productCode;
        this.replyCnt = replyCnt;
    }

    public int getInqSeq() {
        return inqSeq;
    }

    public void setInqSeq(int inqSeq) {
        this.inqSeq = inqSeq;
    }

    public int getInqSubseq() {
        return inqSubseq;
    }

    public void setInqSubseq(int inqSubseq) {
        this.inqSubseq = inqSubseq;
    }

    public int getInqRef() {
        return inqRef;
    }

    public void setInqRef(int inqRef) {
        this.inqRef = inqRef;
    }

    public int getInqDepth() {
        return inqDepth;
    }

    public void setInqDepth(int inqDepth) {
        this.inqDepth = inqDepth;
    }

    public String getInqWriter() {
        return inqWriter;
    }

    public void setInqWriter(String inqWriter) {
        this.inqWriter = inqWriter;
    }

    public String getInqTitle() {
        return inqTitle;
    }

    public void setInqTitle(String inqTitle) {
        this.inqTitle = inqTitle;
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getReplyCnt() {
        return replyCnt;
    }

    public void setReplyCnt(int replyCnt) {
        this.replyCnt = replyCnt;
    }

    @Override
    public String toString() {
        return "ProductInquiryDto [inqSeq=" + inqSeq + ", inqSubseq=" + inqSubseq + ", inqRef=" + inqRef + ", inqDepth="
                + inqDepth + ", inqWriter=" + inqWriter + ", inqTitle=" + inqTitle + ", inqContent=" + inqContent
                + ", inqDate=" + inqDate + ", productId=" + productId + ", memId=" + memId + ", productCode="
                + productCode + ", replyCnt=" + replyCnt + "]";
    }

    
    
    
}
