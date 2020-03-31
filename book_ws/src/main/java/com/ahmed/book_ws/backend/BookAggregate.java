package com.ahmed.book_ws.backend;

import com.ahmed.book_ws.backend.command.BookCommand;
import com.ahmed.book_ws.backend.command.CreateBookCommand;
import com.ahmed.book_ws.backend.command.DeleteBookCommand;
import com.ahmed.book_ws.backend.command.UpdateBookCommand;

import com.ahmed.common.books.BookInfo;
import com.ahmed.common.events.BookAddedEvent;
import com.ahmed.common.events.BookEditedEvent;
import com.ahmed.common.events.BookRemovedEvent;
import io.eventuate.*;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BookAggregate extends ReflectiveMutableCommandProcessingAggregate<BookAggregate, BookCommand> {
    private BookInfo bookInfo;
    private boolean deleted = false;

    private static Logger log = LoggerFactory.getLogger(BookAggregate.class);

   //process methods takes a command and return sequence of events
   public List<Event> proccess(CreateBookCommand cmd){
       if (!this.deleted) {
           log.info("Calling BookAggregate.process for CreateBookCommand : "+ cmd);
           return EventUtil.events(new BookAddedEvent(cmd.getInfo()));
       }
       return new ArrayList<>();
   }
   public  List<Event> proccess(UpdateBookCommand cmd){
    if (!this.deleted) {
        return EventUtil.events(new BookEditedEvent(cmd.getInfo()));
    }
       return new ArrayList<>();
}

   public  List<Event> proccess(DeleteBookCommand cmd){
       if (!this.deleted) {
           return EventUtil.events(new BookRemovedEvent());
       }
       return new ArrayList<>();
   }

   //apply method takes an event and returns updated aggregate
    public void apply(BookAddedEvent event) {
        log.info("Calling BoardAggregate.APPLY for BookAddedEvent : {}", event);


       this.bookInfo = event.getInfo();
    }

    public void apply(BookEditedEvent event) {
        log.info("Calling BoardAggregate.APPLY for BookEditedEvent : {}", event);

        this.bookInfo = event.getInfo();
    }

    public void apply(BookRemovedEvent event) {
        log.info("Calling BoardAggregate.APPLY for BookRemovedEvent : {}", event);
        this.deleted = true;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }
}
