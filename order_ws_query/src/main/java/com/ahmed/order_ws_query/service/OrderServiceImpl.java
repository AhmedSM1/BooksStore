package com.ahmed.order_ws_query.service;

import com.ahmed.order_ws_query.data.Book;
import com.ahmed.order_ws_query.data.OrderEntity;
import com.ahmed.order_ws_query.data.OrderRepo;
import com.ahmed.order_ws_query.util.OrderNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo repo;
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);


    @Override
    public void createOrder(String orderId, String customerId) {
        OrderEntity entity = new OrderEntity(orderId,customerId,0,null);
        this.repo.save(entity);
    }

    @Override
    public void addBook(String orderId, String bookId, String title, double price) {
        if (exist(orderId)){
            Optional<OrderEntity> order = repo.findById(orderId);
            if(order.get().getBooks() != null && !order.get().getBooks().isEmpty()) {
                List<Book> books = order.get().getBooks();
                books.add(new Book(bookId, title, price));
                order.get().setBooks(books);
                order.get().setTotalPrice(getTotalPrice(books));
            } else {
                List<Book> book = new ArrayList<>();
                book.add(new Book(bookId, title, price));
                order.get().setBooks(book);
                order.get().setTotalPrice(getTotalPrice(book));
            }
            this.repo.save(order.get());
        }
        logger.debug(orderId + "doesnt not exist ");
    }




    @Override
    public void removeBook(String orderId, Book entity) {
        if (exist(orderId)) {
            OrderEntity orderEntity = findById(orderId);
            List<Book> books = orderEntity.getBooks();
            if (books.contains(entity)) {
                books.remove(entity);
                orderEntity.setTotalPrice(getTotalPrice(books));
            }
            logger.debug(entity.getBookTitle() + "doesnt not exist in the list ");
        }
        logger.debug(orderId + "doesnt not exist ");


    }

    @Override
    public Boolean exist(String orderId) {
        Boolean present = repo.findById(orderId).isPresent();
        return present;
    }


    @Override
    public OrderEntity findById(String orderId) {
        OrderEntity entity = repo.findById(orderId).orElse(null);
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
