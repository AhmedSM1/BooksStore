package com.ahmed.order_ws.backend.commands;

import com.ahmed.common.ValueObjects.Stock;

public class ApproveOrderCommand implements OrderCommand {
    private String bookId;
    private String orderId;
    private Stock booksReq;
    private double unitPrice;

    public ApproveOrderCommand(String bookId, String orderId, Stock booksReq, double unitPrice) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.booksReq = booksReq;
        this.unitPrice = unitPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Stock getBooksReq() {
        return booksReq;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
