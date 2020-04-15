package com.ahmed.order_ws_query.service;

import com.ahmed.order_ws_query.data.Book;
import com.ahmed.order_ws_query.data.OrderEntity;
import com.ahmed.order_ws_query.data.OrderRepo;
import com.ahmed.order_ws_query.util.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderServiceImpl implements OrderService {
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
        order.setTotalPrice(getTotalPrice(books));
        return order.getBooks();
    }

    @Override
    public List<Book> removeBook(String orderId, Book entity) {
        OrderEntity orderEntity = findById(orderId);
        List<Book> books = orderEntity.getBooks();
        try{
            books.remove(entity);
            orderEntity.setTotalPrice(getTotalPrice(books));
            return books;
        }catch (NoSuchElementException e){
            return books;
        }
    }


    @Override
    public OrderEntity findById(String orderId) {
        OrderEntity entity = repo.findById(orderId).orElseThrow(OrderNotFoundException::new);

        return entity;
    }

    @Override
    public List<OrderEntity> findAll() {
        return repo.findAll();
    }

    private double getTotalPrice(List<Book> books){
        double total = 0;
      if (books != null){
          for (Book book : books) {
              total += book.getUnitPrice();
          }
          return total;
      }else {
          return 0;
      }

    }


}
