package com.ahmed.book_ws.backend;

import com.ahmed.book_ws.backend.Service.BookDTO;
import com.ahmed.book_ws.backend.command.BookCommand;
import com.ahmed.book_ws.backend.command.CreateBookCommand;
import com.ahmed.book_ws.backend.command.DeleteBookCommand;
import com.ahmed.book_ws.backend.command.UpdateBookCommand;

import com.ahmed.common_backend.books.events.BookAddedEvent;
import com.ahmed.common_backend.books.events.BookEditedEvent;
import com.ahmed.common_backend.books.events.BookRemovedEvent;
import io.eventuate.*;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookAggregate extends ReflectiveMutableCommandProcessingAggregate<BookAggregate, BookCommand> {

    private static Logger log = LoggerFactory.getLogger(BookAggregate.class);



    //process methods takes a command and return sequence of events
    public List<Event> process(CreateBookCommand cmd){
            log.info("Calling BookAggregate.process for CreateBookCommand : "+ cmd);
            return EventUtil.events(new BookAddedEvent(
                    cmd.getDto().getBookId(),
                    cmd.getDto().getBookTitle(),
                    cmd.getDto().getAvailableItemCount(),
                    cmd.getDto().getPrice()));
    }
    public  List<Event> process(UpdateBookCommand cmd){
        log.info("Calling BookAggregate.process for UpdateBookCommand : "+ cmd);
            return EventUtil.events(new BookEditedEvent(
                    cmd.getBookDTO().getBookId(),
                    cmd.getBookDTO().getBookTitle(),
                    cmd.getBookDTO().getAvailableItemCount(),
                    cmd.getBookDTO().getPrice(),
                    cmd.getBookDTO().getDescription()));

    }
    public  List<Event> process(DeleteBookCommand cmd){
            return EventUtil.events(new BookRemovedEvent(cmd.getBookId()));
        }

    //apply method takes an event and returns updated aggregate
    public void apply(BookAddedEvent event) {
        log.info("Calling BoardAggregate.APPLY for BookAddedEvent : {}", event);
    }

    public void apply(BookEditedEvent event) {
        log.info("Calling BoardAggregate.APPLY for BookEditedEvent : {}", event);

    }

    public void apply(BookRemovedEvent event) {
        log.info("Calling BoardAggregate.APPLY for BookRemovedEvent : {}", event);

    }



}
