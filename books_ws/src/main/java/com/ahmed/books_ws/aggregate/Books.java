package com.ahmed.books_ws.aggregate;

import com.ahmed.books_ws.commands.BooksCommand;
import com.ahmed.books_ws.commands.CreateBookCommand;
import com.ahmed.books_ws.commands.DeleteBookCommand;
import com.ahmed.books_ws.commands.UpdateBookCommand;

import com.ahmed.common.books.*;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static io.eventuate.EventUtil.events;


public class Books extends ReflectiveMutableCommandProcessingAggregate<Books, BooksCommand> {

   private int availableItemCount;
   private BookInfo info;
   private BookStatus status;
    Logger logger = LoggerFactory.getLogger(Books.class);

    public Books(int availableItemCount, BookInfo info, BookStatus status) {
        this.availableItemCount = availableItemCount;
        this.info = info;
        this.status = status;
    }

    public Books() {
    }

    public List<Event> process(CreateBookCommand cmd) {
        info = cmd.getInfo();
        availableItemCount = info.getAvailableItemCount();
        logger.debug("Create book event");
        if (availableItemCount > 0){
            status = BookStatus.AVALIBLE;
        }else{
            status = BookStatus.OUTOFSTOCK;
        }
       // return EventUtil.events(new BookCreatedEvent(info,status));
        return events(new BookCreatedEvent(info,status));
    }
    public void apply(BookCreatedEvent event) {

        this.info = event.getInfo();
        this.status = event.getBookStatus();
    }

    public List<Event> process(UpdateBookCommand cmd) {
        logger.debug("update book event");

        info = cmd.getInfo();
        availableItemCount = cmd.getInfo().getAvailableItemCount();
        if (availableItemCount > 0){
            status = BookStatus.AVALIBLE;
        }else{
            status = BookStatus.OUTOFSTOCK;
        }

        return events(new BookEditedEvent(info,status));
    }
    public void apply(BookEditedEvent event) {
        this.info = event.getInfo();
        this.status = event.getStatus();
    }
    public List<Event> process(DeleteBookCommand cmd) {
        logger.debug("delete book event");

        status = BookStatus.REMOVED;
        return events(new BookRemovedEvent(cmd.getBookId(),status));
    }
    public void apply(BookRemovedEvent event) {
        this.status = event.getStatus();
    }

    public int getAvailableItemCount() {
        return availableItemCount;
    }

    public BookInfo getInfo() {
        return info;
    }

    public BookStatus getStatus() {
        return status;
    }
}
