package com.ahmed.order_ws.aggregate;

import com.ahmed.common.order.events.*;
import com.ahmed.order_ws.model.OrderState;
import com.ahmed.order_ws.commands.*;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

import java.util.List;

public class Order extends ReflectiveMutableCommandProcessingAggregate<Order , OrderCommand> {

    private int amount;
    private double totalPrice;
    private OrderState orderState;
    private String customerId;

    public List<Event> process(CreateOrderCommand cmd) {
        return EventUtil.events(new OrderCreatedEvent(cmd.getCustomerId()));
    }
    public void apply(OrderCreatedEvent event) {
        this.orderState = OrderState.CREATED;
        this.customerId = event.getCustomerId();
    }

    public List<Event> process(ApproveOrderCommand cmd) {
        return EventUtil.events(new OrderApprovedEvent(cmd.getBookId(),cmd.getOrderId(),cmd.getBooksReq(),cmd.getUnitPrice()));
    }
    public void apply(OrderApprovedEvent event) {
        this.amount = event.getBooksRequested();
        this.totalPrice = event.getUnitPrice() * amount;
        this.orderState = OrderState.APPROVED;
    }
    public List<Event> process(RejectOrderCommand cmd) {
        return EventUtil.events(new OrderRejectedEvent(cmd.getBookId(),cmd.getOrderId()));
    }
    public void apply(OrderRejectedEvent event) {
        this.orderState = OrderState.REJECTED;
    }

    public List<Event> process(AddBookToOrderCommand cmd) {
        return EventUtil.events(new BookIsAddedToOrderEvent(cmd.getBookId(),cmd.getOrderId(),cmd.getUnitPrice(),cmd.getBookAmount()));
    }
    public void apply(BookIsAddedToOrderEvent event) {
       this.amount = event.getBookAmount();
       this.totalPrice = event.getUnitPrice() * amount;
       this.orderState = OrderState.PENDING;
    }
    public List<Event> process(RemoveBookFromOrderCommand cmd) {
        return EventUtil.events(new BookIsRemovedFromOrderEvent(cmd.getOrderId(),
                cmd.getBookId()
                ,cmd.getAmountToRemove(),
                cmd.getMoneyToRemove()));
    }
    public void apply(BookIsRemovedFromOrderEvent event) {
        this.amount = event.getAmountToRemove();
        this.totalPrice = event.getUnitPrice() * amount;
        this.orderState = OrderState.PENDING;
    }

    public int getAmount() {
        return amount;
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
}
