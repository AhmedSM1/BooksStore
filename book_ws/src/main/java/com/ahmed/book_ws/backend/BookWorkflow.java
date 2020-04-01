package com.ahmed.book_ws.backend;


import com.ahmed.book_ws.backend.Model.BookRequestModel;
import com.ahmed.book_ws.backend.Service.BookDTO;
import com.ahmed.book_ws.backend.command.CreateBookCommand;
import com.ahmed.book_ws.backend.command.DeleteBookCommand;
import com.ahmed.book_ws.backend.command.UpdateBookCommand;
import com.ahmed.book_ws.backend.events.BookAddedEvent;


import com.ahmed.book_ws.backend.events.BookEditedEvent;
import com.ahmed.book_ws.backend.events.BookRemovedEvent;
import io.eventuate.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@EventSubscriber(id = "BooksCommandSideEventHandlers")
public class BookWorkflow {
    private static Logger log = LoggerFactory.getLogger(BookWorkflow.class);

   @EventHandlerMethod
    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> addBook(EventHandlerContext<BookAddedEvent> eventhandler){
       //getting the event
       BookAddedEvent bookAddedEvent = eventhandler.getEvent();

       Optional<String> entityId = Optional.ofNullable( eventhandler.getEntityId()).filter(s -> !s.isEmpty());
      log.debug("entity id  is "+entityId);

      BookDTO dto = eventhandler.getEvent().getDto();
       log.debug("Event is "+bookAddedEvent);

       log.debug("     book title is "+dto.getBookTitle()+ "price: "+dto.getPrice()+ " amount "+dto.getBookId()+"   id is"+dto.getBookId());



      return eventhandler.save(BookAggregate.class,  new CreateBookCommand(dto),entityId);

   }
   @EventHandlerMethod
   public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> updateBook(EventHandlerContext<BookEditedEvent> eventhandler){
      BookEditedEvent bookEditedEvent = eventhandler.getEvent();
      BookDTO dto = eventhandler.getEvent().getDto();
      return eventhandler.update(BookAggregate.class, dto.getBookId(), new UpdateBookCommand(dto));

   }
   @EventHandlerMethod
   public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> deleteBook(EventHandlerContext<BookRemovedEvent> ctx) {
      String bookid = ctx.getEvent().getBookId();

      return ctx.update(BookAggregate.class, bookid, new DeleteBookCommand(bookid));
   }
}
