package com.ahmed.order_ws.backend;

import com.ahmed.common.ValueObjects.Stock;
import com.ahmed.common.order.events.*;
import com.ahmed.common.orderBook.BooksNotAvaliableEvent;
import com.ahmed.order_ws.backend.commands.*;
import com.ahmed.order_ws.backend.model.OrderState;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

import java.util.List;

public class Order extends ReflectiveMutableCommandProcessingAggregate<Order , OrderCommand> {

    private Stock amount;
    private double totalPrice;
    private BookState bookState;
    private OrderState orderState;

    public List<Event> process(CreateOrderCommand cmd) {
        return EventUtil.events(new OrderCreatedEvent(cmd.getCustomerId()));
    }
    public void apply(OrderCreatedEvent event) {
        this.orderState = OrderState.CREATED;
    }



    public List<Event> process(ApproveOrderCommand cmd) {
        return EventUtil.events(new OrderApprovedEvent(cmd.getBookId(),cmd.getOrderId(),cmd.getBooksReq(),cmd.getUnitPrice()));
    }
    public void apply(OrderApprovedEvent event) {
        this.amount = event.getBooksRequested();
        this.totalPrice = event.getUnitPrice() * amount.getBooks();
        this.orderState = OrderState.APPROVED;
    }
    public List<Event> process(RejectOrderCommand cmd) {
        return EventUtil.events(new OrderRejectedEvent(cmd.getBookId(),cmd.getOrderId()));
    }
    public void apply(OrderRejectedEvent event) {
        this.orderState = OrderState.REJECTED;
    }

    public List<Event> process(AddBookToOrderCommand cmd) {
        return EventUtil.events(new BookIsAddedToOrderEvent(cmd.getOrderBook().getBookId(),
                cmd.getOrderBook().getOrderId()
                ,cmd.getOrderBook().getAmountRequested()
                ,cmd.getOrderBook().getUnitPrice()));
    }
    public void apply(BookIsAddedToOrderEvent event) {
       this.amount = event.getAmountAsked();
       this.totalPrice = event.getUnitPrice() * amount.getBooks();
       this.bookState = BookState.ADDED;
    }
    public List<Event> process(RemoveBookFromOrderCommand cmd) {
        return EventUtil.events(new BookIsRemovedFromOrderEvent(cmd.getOrderId(),
                cmd.getBookId()
                ,cmd.getAmountToRemove(),
                cmd.getMoneyToRemove()));
    }
    public void apply(BookIsRemovedFromOrderEvent event) {
        this.amount = event.getAmountToRemove();
        this.totalPrice = event.getUnitPrice() * amount.getBooks();
        this.bookState = BookState.REMOVED;
    }
    public void apply(BooksNotAvaliableEvent event) {
        this.orderState = OrderState.REJECTED;
        this.bookState = BookState.OUTOFSTOCK;
    }

    public BookState getBookState() {
        return bookState;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Stock getAmount() {
        return amount;
    }
}
