package com.main.books_ws_query.service;


import com.ahmed.common.books.BookCreatedEvent;
import com.ahmed.common.books.BookEditedEvent;
import com.ahmed.common.books.BookInfo;
import com.ahmed.common.books.BookRemovedEvent;
import com.main.books_ws_query.data.BookEntity;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import org.springframework.beans.factory.annotation.Autowired;

@EventSubscriber(id = "book")
public class BookSubscriber {
    private BookService service;

    @Autowired
    public BookSubscriber(BookService service) {
        this.service = service;
    }

    @EventHandlerMethod
    public void createBook(DispatchedEvent<BookCreatedEvent> event){
        BookInfo info = event.getEvent().getInfo();
        BookEntity entity = new BookEntity(event.getEntityId(),info.getTitle(),info.getDescription(),info.getPrice(),info.getAvailableItemCount(),event.getEvent().getBookStatus());
        this.service.createBook(entity);
    }
    @EventHandlerMethod
    public void updateBook(DispatchedEvent<BookEditedEvent> event){
        BookInfo info = event.getEvent().getInfo();
        this.service.updateBook(event.getEntityId(),info);
    }

    @EventHandlerMethod
    public void deleteBook(DispatchedEvent<BookRemovedEvent> event){
        this.service.deleteBook(event.getEntityId());
    }


}
