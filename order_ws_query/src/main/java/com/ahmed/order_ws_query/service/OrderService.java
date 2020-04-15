package com.ahmed.order_ws_query.service;

import com.ahmed.order_ws_query.data.Book;
import com.ahmed.order_ws_query.data.OrderEntity;
import io.eventuate.EntityWithIdAndVersion;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface OrderService {
    void createOrder(String orderId,String customerId);
    void addBook(String orderId, String bookId,String title,double price);
    void removeBook(String orderId, Book entity);
    Boolean exist(String orderId);
    OrderEntity findById(String orderId);

    List<OrderEntity> findAll();

}
