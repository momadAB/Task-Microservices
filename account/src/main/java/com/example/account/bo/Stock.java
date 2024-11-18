package com.example.account.bo;

public class Stock {
    private String item;

    private int quantity;

    private long id;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "item='" + item + '\'' +
                ", remainingQty=" + quantity +
                ", orderId=" + id +
                '}';
    }
}
