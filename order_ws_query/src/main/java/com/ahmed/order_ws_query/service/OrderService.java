package com.ahmed.order_ws_query.service;

import com.ahmed.order_ws_query.data.Book;
import com.ahmed.order_ws_query.data.OrderEntity;

import java.util.List;

public interface OrderService {
    void createOrder(String orderId,String customerId);
    List<Book> addBook(String orderId, Book entity);
    List<Book> removeBook(String orderId, Book entity);

    OrderEntity findById(String orderId);


}
