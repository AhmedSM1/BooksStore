package com.ahmed.order_ws.aggregate;

import com.ahmed.common.order.events.*;
import com.ahmed.order_ws.model.OrderState;
import com.ahmed.order_ws.commands.*;
import io.eventuate.Event;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static io.eventuate.EventUtil.events;

public class Order extends ReflectiveMutableCommandProcessingAggregate<Order,OrderCommand> {

    private double totalPrice;
    private OrderState orderState;
    private String customerId;
    private String bookId;
    Logger logger = LoggerFactory.getLogger(Order.class);

    public List<Event> process(CreateOrderCommand cmd) {
        return events(new OrderCreatedEvent(cmd.getCustomerId()));
    }
    public void apply(OrderCreatedEvent event) {
        this.orderState = OrderState.CREATED;
        this.customerId = event.getCustomerId();
    }

    public List<Event> process(AddBookToOrderCommand cmd) {
        logger.debug("Order Aggregate ----  Add Book To order command"+cmd.getBookId());
        return events(new BookIsAddedToOrderEvent(cmd.getBookId(),cmd.getOrderId(),cmd.getUnitPrice()));
    }
    public void apply(BookIsAddedToOrderEvent event) {
        this.orderState = OrderState.PENDING;
       this.bookId = event.getBookId();
       this.totalPrice += event.getUnitPrice();
    }
    public List<Event> process(RemoveBookFromOrderCommand cmd) {
        logger.debug("Order Aggregate ----  remove Book from order command"+cmd.getBookId());
        return events(new BookIsRemovedFromOrderEvent(cmd.getOrderId(),cmd.getBookId(),cmd.getMoneyToRemove()));
    }
    public void apply(BookIsRemovedFromOrderEvent event) {
        this.orderState = OrderState.PENDING;
        this.bookId = event.getBookId();
        this.totalPrice -= event.getUnitPrice();
    }
    public List<Event> process(ApproveOrderCommand cmd) {
        logger.debug("Order Aggregate ----  approve order command"+cmd.getBookId());
        return events(new OrderApprovedEvent(cmd.getOrderId(),cmd.getBookId()));
    }
    public void apply(OrderApprovedEvent event) {
        this.orderState = OrderState.APPROVED;
        this.bookId = event.getBookId();
    }
    public List<Event> process(RejectOrderCommand cmd) {
        logger.debug("Order Aggregate ----  reject order command"+cmd.getBookId());
        return events(new OrderApprovedEvent(cmd.getOrderId(),cmd.getBookId()));
    }
    public void apply(OrderRejectedEvent event) {
        this.orderState = OrderState.REJECTED;
        this.bookId = event.getBookId();
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getBookId() {
        return bookId;
    }
}
