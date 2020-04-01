package com.ahmed.book_ws.backend;


import com.ahmed.book_ws.backend.Service.BookDTO;

import com.ahmed.book_ws.backend.command.DeleteBookCommand;
import com.ahmed.book_ws.backend.command.UpdateBookCommand;


import com.ahmed.common_backend.books.events.BookEditedEvent;
import com.ahmed.common_backend.books.events.BookRemovedEvent;
import io.eventuate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

@EventSubscriber(id = "BooksCommandSideEventHandlers")
public class BookWorkflow {
    private static Logger log = LoggerFactory.getLogger(BookWorkflow.class);

   @EventHandlerMethod
   public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> updateBook(EventHandlerContext<BookEditedEvent> eventhandler){
       log.debug("Event handler in update book event: "+eventhandler);
      BookEditedEvent event = eventhandler.getEvent();
      log.debug("update book event: "+event);
      BookDTO dto = new BookDTO(
              event.getId(),
              event.getTitle(),
              event.getDescription(),
              event.getPrice(),
              event.getStock());
      return eventhandler.update(BookAggregate.class,event.getId(), new UpdateBookCommand(dto));
   }
   @EventHandlerMethod
   public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> deleteBook(EventHandlerContext<BookRemovedEvent> ctx) {
      String bookid = ctx.getEvent().getBookId();

      return ctx.update(BookAggregate.class, bookid, new DeleteBookCommand(bookid));
   }
}
