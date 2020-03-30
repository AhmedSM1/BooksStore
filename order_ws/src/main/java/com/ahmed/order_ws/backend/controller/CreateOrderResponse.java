package com.ahmed.order_ws.backend.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



public class CreateOrderResponse {
    @NotNull(message = "productId should not be null!")
    @NotEmpty(message = "productId should not be empty!")
    private String bookId;







    
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public CreateOrderResponse(
            @NotNull(message = "productId should not be null!") @NotEmpty(message = "productId should not be empty!") String bookId) {
        this.bookId = bookId;
    }



}
