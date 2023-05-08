package com.dalrun.dto;

import java.io.Serializable;

public class CartDto implements Serializable{
    
    private String cartId;
    private String cartProdName;  // 사용성 없을시 삭제 예정.
    private String cartProdQuantity;
    private String cartProdPrice;  // 사용성 없을시 삭제 예정.
    private String productId;
    private String memId;
    private String orderSeq;

    public CartDto() {
        // TODO Auto-generated constructor stub
    }

    public CartDto(String cartId, String cartProdName, String cartProdQuantity, String cartProdPrice, String productId,
            String memId, String orderSeq) {
        super();
        this.cartId = cartId;
        this.cartProdName = cartProdName;
        this.cartProdQuantity = cartProdQuantity;
        this.cartProdPrice = cartProdPrice;
        this.productId = productId;
        this.memId = memId;
        this.orderSeq = orderSeq;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCartProdName() {
        return cartProdName;
    }

    public void setCartProdName(String cartProdName) {
        this.cartProdName = cartProdName;
    }

    public String getCartProdQuantity() {
        return cartProdQuantity;
    }

    public void setCartProdQuantity(String cartProdQuantity) {
        this.cartProdQuantity = cartProdQuantity;
    }

    public String getCartProdPrice() {
        return cartProdPrice;
    }

    public void setCartProdPrice(String cartProdPrice) {
        this.cartProdPrice = cartProdPrice;
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

    public String getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(String orderSeq) {
        this.orderSeq = orderSeq;
    }

    @Override
    public String toString() {
        return "CartDto [cartId=" + cartId + ", cartProdName=" + cartProdName + ", cartProdQuantity=" + cartProdQuantity
                + ", cartProdPrice=" + cartProdPrice + ", productId=" + productId + ", memId=" + memId + ", orderSeq="
                + orderSeq + "]";
    }
    
    
}
