package com.ahmed.order_ws.service;

import com.ahmed.order_ws.model.BookResponseModel;

public interface BookServiceRestTemplete {
    BookResponseModel getBook(String bookId);

}
