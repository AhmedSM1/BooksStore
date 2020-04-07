package com.ahmed.common.orderBook;

import com.ahmed.common.ValueObjects.Stock;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class BookOrderIsCreatedEvent implements OrderBookEvent {
    private final String bookId;
    private final String orderId;
    private final Stock amountAsked;

    public BookOrderIsCreatedEvent(String bookId, String orderId, Stock amountAsked) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.amountAsked = amountAsked;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Stock getAmountAsked() {
        return amountAsked;
    }
}
