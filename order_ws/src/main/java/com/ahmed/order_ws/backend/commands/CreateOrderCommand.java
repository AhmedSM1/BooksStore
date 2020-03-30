package com.ahmed.order_ws.backend.commands;

public class CreateOrderCommand implements OrderCommand {
    private Long bookId;
    private int  totalPrice;

    public CreateOrderCommand(Long bookId, int totalPrice) {
        this.bookId = bookId;
        this.totalPrice = totalPrice;
    }

    public Long getBookId() {
        return bookId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
