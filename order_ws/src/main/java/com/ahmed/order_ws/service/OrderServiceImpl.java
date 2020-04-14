package com.ahmed.order_ws.service;

import com.ahmed.order_ws.aggregate.Order;
import com.ahmed.order_ws.commands.AddBookToOrderCommand;
import com.ahmed.order_ws.commands.CreateOrderCommand;
import com.ahmed.order_ws.commands.OrderCommand;
import com.ahmed.order_ws.commands.RemoveBookFromOrderCommand;
import com.ahmed.order_ws.model.AddBookRequest;
import com.ahmed.order_ws.model.OrderInfo;
import com.ahmed.order_ws.model.RemoveBookRequest;

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
        customerService.verifyCustomerCustomerId(customerId);
        logger.debug("Create Order service ");
        logger.debug("customer id:  "+customerId);
        return orderRepository.save(new CreateOrderCommand(customerId));
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Order>> addBook(AddBookRequest request) {
        bookService.verifyBookId(request.getBookId());
        logger.debug("add book to order  service ");
        logger.debug("book id:  "+request.getBookId());
        return orderRepository.save(new AddBookToOrderCommand(request.getBookId(),request.getOrderId(),request.getUnitPrice()));
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Order>> removeBook(RemoveBookRequest request) {
        bookService.verifyBookId(request.getBookId());
        logger.debug("remove book to order  service ");
        logger.debug("book id:  "+request.getBookId());
        return orderRepository.update(request.getOrderId(),new RemoveBookFromOrderCommand(request.getOrderId(),request.getBookId(),request.getMoneyToRemove()));
    }
}
