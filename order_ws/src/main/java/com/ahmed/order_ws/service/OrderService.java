package com.ahmed.order_ws.service;

import com.ahmed.common.books.BookInfo;
import com.ahmed.order_ws.aggregate.Order;
import com.ahmed.order_ws.model.AddBookRequest;
import com.ahmed.order_ws.model.OrderInfo;
import com.ahmed.order_ws.model.RemoveBookRequest;
import io.eventuate.EntityWithIdAndVersion;

import java.util.concurrent.CompletableFuture;

public interface OrderService {
    CompletableFuture<EntityWithIdAndVersion<Order>> createOrder(String CustomerId);
    CompletableFuture<EntityWithIdAndVersion<Order>> addBook(AddBookRequest request);
    CompletableFuture<EntityWithIdAndVersion<Order>> removeBook(RemoveBookRequest request);
}
