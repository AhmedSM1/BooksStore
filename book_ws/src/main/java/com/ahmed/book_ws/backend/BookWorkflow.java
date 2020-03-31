package com.ahmed.book_ws.backend;


import com.ahmed.common.books.BookInfo;
import com.ahmed.common.events.BookAddedEvent;


import io.eventuate.EventHandlerContext;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EventSubscriber(id = "bookEventHandlers")
public class BookWorkflow {
    private static Logger log = LoggerFactory.getLogger(BookWorkflow.class);

   @EventHandlerMethod
    public void addBook(EventHandlerContext<BookAddedEvent> eventhandler){
       //getting the event
       BookAddedEvent bookAddedEvent = eventhandler.getEvent();
       log.debug("Event is "+bookAddedEvent);

       String bookTitle = bookAddedEvent.getInfo().getBookTitle();
       double price = bookAddedEvent.getInfo().getPrice();
       String description = bookAddedEvent.getInfo().getDescription();
       int  amoutAvalible = bookAddedEvent.getInfo().getAvailableItemCount();
       String bookId = eventhandler.getEntityId();
       log.debug("     book title is "+bookTitle+ "price: "+price+ " amount "+amoutAvalible+"   id is"+bookId);

       BookInfo info = new BookInfo(bookTitle,description,price,amoutAvalible);

   }

}
