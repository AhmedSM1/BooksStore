package com.ahmed.order_book.config;


import com.ahmed.common.books.RequestBookAmountEvent;
import com.ahmed.common.orderBook.BookIsAvailableEvent;
import com.ahmed.order_book.domain.OrderBook;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import io.eventuate.sync.EventHandlerContext;

import java.util.concurrent.CompletableFuture;

@EventSubscriber(id="orderBookWorkflow")
public class BookOrderWorkflow {

    @EventHandlerMethod
    public CompletableFuture<EntityWithIdAndVersion<OrderBook>> askedAmountOfBooks(EventHandlerContext<RequestBookAmountEvent> ctx) {
        String orderId = ctx.getEvent().getOrderId();
        String bookId = ctx.getEvent().getBookId();
        return ctx.update(Order.class, orderId, new BookIsAvailableEvent(bookId));
    }

}
