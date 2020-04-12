package com.ahmed.order_ws.commands;

public class ApproveOrderCommand implements OrderCommand {
    private String bookId;
    private String orderId;
    private int booksReq;
    private double unitPrice;

    public ApproveOrderCommand(String bookId, String orderId, int booksReq, double unitPrice) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.booksReq = booksReq;
        this.unitPrice = unitPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getBooksReq() {
        return booksReq;
    }

    public void setBooksReq(int booksReq) {
        this.booksReq = booksReq;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
