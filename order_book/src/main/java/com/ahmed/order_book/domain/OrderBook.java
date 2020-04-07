package com.ahmed.order_book.domain;

import com.ahmed.common.ValueObjects.Stock;
import com.ahmed.common.orderBook.BookIsAvailableEvent;
import com.ahmed.common.orderBook.BookOrderIsCreatedEvent;
import com.ahmed.common.orderBook.BooksNotAvaliableEvent;
import io.eventuate.Event;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

import java.util.List;

import static io.eventuate.EventUtil.events;

public class OrderBook extends ReflectiveMutableCommandProcessingAggregate<OrderBook, OrderBookCommand> {
    private Stock quantityAsked;
    private BookState state;
    private String orderId;
    private String bookId;



    public List<Event> process(CreateOrderBookCommand cmd) {
     return events(new BookOrderIsCreatedEvent(cmd.getBookId(),cmd.getOrderId(),cmd.getAmountAsked()));
    }
    public void apply(BookOrderIsCreatedEvent event) {
       this.state = BookState.CREATED;
       this.bookId = event.getBookId();
       this.orderId = event.getOrderId();
       this.quantityAsked = event.getAmountAsked();
    }

    public List<Event> process(ApproveBookCommand cmd) {
        return events(new BookIsAvailableEvent(bookId));
    }

    public List<Event> process(RejectBookCommand cmd) {
        return events(new BookIsAvailableEvent(bookId));
    }
    public void apply(BookIsAvailableEvent event) {
        this.bookId = event.getBookId();
        this.state = state.APPROVED;
    }


    public void apply(BooksNotAvaliableEvent event) {
        this.bookId = event.getBookId();
        this.state = state.REJECTED;
    }


    public BookState getState() {
        return state;
    }

    public Stock getQuantityAsked() {
        return quantityAsked;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBookId() {
        return bookId;
    }


}
