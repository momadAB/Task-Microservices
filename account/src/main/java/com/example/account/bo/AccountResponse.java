package com.example.account.bo;

import java.util.List;

public class AccountResponse {
    List<Stock> stocks;
    String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "AccountResponse{" + "stocks=" + stocks + ", status='" + status + '\'' + '}';
    }
}
