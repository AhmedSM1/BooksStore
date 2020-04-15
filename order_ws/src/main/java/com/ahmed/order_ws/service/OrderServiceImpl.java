package com.ahmed.order_ws.service;

import com.ahmed.order_ws.aggregate.Order;
import com.ahmed.order_ws.commands.AddBookToOrderCommand;
import com.ahmed.order_ws.commands.CreateOrderCommand;
import com.ahmed.order_ws.commands.OrderCommand;
import com.ahmed.order_ws.commands.RemoveBookFromOrderCommand;
import com.ahmed.order_ws.model.*;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class OrderServiceImpl implements OrderService {

    private AggregateRepository<Order, OrderCommand> orderRepository;
    private CustomerServiceRestTemplete customerService;
    private BookServiceRestTemplete bookService;

    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);


    public OrderServiceImpl(AggregateRepository<Order, OrderCommand> orderRepository,
                            CustomerServiceRestTemplete customerService,
                            BookServiceRestTemplete bookService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.bookService = bookService;
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Order>> createOrder(String customerId) {
       CustomerResponseModel customer =  customerService.getCustomer(customerId);
        logger.debug("Create Order service ");
        logger.debug("customer id:  "+customerId);
        return orderRepository.save(new CreateOrderCommand(customer.getCustomerId()));
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Order>> addBook(String orderId , String bookId) {
        BookResponseModel book = bookService.getBook(bookId);
        logger.debug("add book to order  service ");
        logger.debug("book id:  "+bookId);
        //String bookId, String orderId, String bookTitle, double unitPrice command
        //String bookId, String bookTitle, String orderId, double unitPrice event
        return orderRepository.update(orderId,new AddBookToOrderCommand(book.getBookId(),orderId,book.getTitle(),book.getPrice()));
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Order>> removeBook(String orderId,RemoveBookRequest request) {
        BookResponseModel book = bookService.getBook(request.getBookId());
        logger.debug("remove book to order  service ");
        logger.debug("book id:  "+request.getBookId());
        return orderRepository.update(orderId,new RemoveBookFromOrderCommand(book.getBookId(),orderId,book.getTitle(),book.getPrice()));
    }
}
