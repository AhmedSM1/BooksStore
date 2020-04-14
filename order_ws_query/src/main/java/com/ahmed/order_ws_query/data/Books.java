package com.ahmed.order_ws_query.data;

public class Books {
    private String bookId;
    private String bookTitle;
    private String unitPrice;

    public Books(String bookId, String bookTitle, String unitPrice) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.unitPrice = unitPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}
