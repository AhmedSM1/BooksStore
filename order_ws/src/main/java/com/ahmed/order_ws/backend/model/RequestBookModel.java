package com.ahmed.order_ws.backend.model;

import com.ahmed.common.ValueObjects.Stock;

public class RequestBookModel {
    private String title;
    private Stock amountReq;

    public RequestBookModel(String title, Stock amountReq) {
        this.title = title;
        this.amountReq = amountReq;
    }

    public String getTitle() {
        return title;
    }

    public Stock getAmountReq() {
        return amountReq;
    }
}
