package com.ahmed.order_ws_query.service;

import com.ahmed.common.customers.CustomerCreatedEvent;
import com.ahmed.common.customers.CustomerInfo;
import com.ahmed.common.order.events.BookIsAddedToOrderEvent;
import com.ahmed.common.order.events.BookIsRemovedFromOrderEvent;
import com.ahmed.common.order.events.OrderCreatedEvent;
import com.ahmed.order_ws_query.data.Book;
import com.ahmed.order_ws_query.data.OrderEntity;
import io.eventuate.DispatchedEvent;
import io.eventuate.EventEntity;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import org.springframework.beans.factory.annotation.Autowired;

@EventSubscriber(id = "Order")
@EventHandlerMethod
public class OrderSubscriber {
    OrderService orderService;
    String orderId;
    String bookId;
    String bookTitle;
    double unitPrice;

    @Autowired
    public OrderSubscriber(OrderService orderService) {
        this.orderService = orderService;
    }
    @EventHandlerMethod
    public void createOrder(DispatchedEvent<OrderCreatedEvent> event){
        String orderId = event.getEntityId();
        String customerId = event.getEvent().getCustomerId();
        orderService.createOrder(orderId,customerId);
    }

    @EventHandlerMethod
    public void addOrder(DispatchedEvent<BookIsAddedToOrderEvent> event){
         orderId = event.getEntityId();
         bookId = event.getEvent().getBookId();
         bookTitle = event.getEvent().getBookTitle();
         unitPrice = event.getEvent().getUnitPrice();
          Book book = new Book(bookId,bookTitle,unitPrice);

        orderService.addBook(orderId,book);
    }
    @EventHandlerMethod
    public void removeOrder(DispatchedEvent<BookIsRemovedFromOrderEvent> event){
        String orderId = event.getEntityId();
        String bookId = event.getEvent().getBookId();
        String bookTitle = event.getEvent().getBookTitle();
        double unitPrice = event.getEvent().getUnitPrice();
        OrderEntity entity = orderService.findById(orderId);
        Book book = new Book(bookId,bookTitle,unitPrice);
        entity.getBooks().remove(book);
    }
}
