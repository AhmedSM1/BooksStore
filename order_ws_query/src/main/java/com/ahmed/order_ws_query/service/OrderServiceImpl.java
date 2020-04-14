package com.ahmed.order_ws_query.service;

import com.ahmed.order_ws_query.data.Book;
import com.ahmed.order_ws_query.data.OrderEntity;
import com.ahmed.order_ws_query.data.OrderRepo;
import com.ahmed.order_ws_query.util.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo repo;


    @Override
    public void createOrder(String orderId, String customerId) {
        OrderEntity entity = new OrderEntity(orderId,customerId,0,null);
        this.repo.save(entity);
    }

    @Override
    public List<Book> addBook(String orderId, Book book) {
        OrderEntity order = findById(orderId);
        List<Book> books = order.getBooks();
        books.add(book);
        order.setTotalPrice(getTotalPrice(orderId));
        return order.getBooks();
    }

    @Override
    public List<Book> removeBook(String orderId, Book entity) {
        List<Book> books = findById(orderId).getBooks();
        return books;
    }


    @Override
    public OrderEntity findById(String orderId) {
        OrderEntity entity = repo.findById(orderId).orElseThrow(OrderNotFoundException::new);

        return entity;
    }

    private double getTotalPrice(String orderId){
        OrderEntity entity = findById(orderId);
        List<Book> books = entity.getBooks();
        double total = 0;
        for (Book book : books) {
            total += book.getUnitPrice();
        }
        entity.setTotalPrice(total);
        return total;
    }


}
