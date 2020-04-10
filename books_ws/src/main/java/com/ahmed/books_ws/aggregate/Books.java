package com.ahmed.books_ws.aggregate;

import com.ahmed.books_ws.commands.BooksCommand;
import com.ahmed.books_ws.commands.CreateBookCommand;
import com.ahmed.books_ws.commands.DeleteBookCommand;
import com.ahmed.books_ws.commands.UpdateBookCommand;
import com.ahmed.common.books.*;
import com.ahmed.common.ValueObjects.Stock;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

import java.util.List;


public class Books extends ReflectiveMutableCommandProcessingAggregate<Books, BooksCommand> {

   private int availableItemCount;
   private BookInfo info;
   private BookStatus status;

    public List<Event> process(CreateBookCommand cmd) {
        info = cmd.getInfo();
        availableItemCount = info.getAvailableItemCount();

        if (availableItemCount > 0){
            status = BookStatus.AVALIBLE;
        }else{
            status = BookStatus.OUTOFSTOCK;
        }
        return EventUtil.events(new BookCreatedEvent(info,status));
    }
    public void apply(BookCreatedEvent event) {

        this.info = event.getInfo();
        this.status = event.getBookStatus();
    }

    public List<Event> process(UpdateBookCommand cmd) {
        info = cmd.getInfo();
        availableItemCount = cmd.getInfo().getAvailableItemCount();
        if (availableItemCount > 0){
            status = BookStatus.AVALIBLE;
        }else{
            status = BookStatus.OUTOFSTOCK;
        }

        return EventUtil.events(new BookEditedEvent(info,status));
    }
    public void apply(BookEditedEvent event) {
        this.info = event.getInfo();
        this.status = event.getStatus();
    }
    public List<Event> process(DeleteBookCommand cmd) {
        status = BookStatus.REMOVED;
        return EventUtil.events(new BookRemovedEvent(cmd.getBookId(),status));
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
