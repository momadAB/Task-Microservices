package com.example.demo.bo;

public class StockResponse {

    private String item;

    private Long remainingQty;

    private Long orderId;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(Long remainingQty) {
        this.remainingQty = remainingQty;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}