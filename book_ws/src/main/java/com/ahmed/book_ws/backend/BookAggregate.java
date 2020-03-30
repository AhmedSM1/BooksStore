package com.ahmed.book_ws.backend;

import com.ahmed.book_ws.backend.command.BookCommand;
import com.ahmed.book_ws.backend.command.CreateBookCommand;
import com.ahmed.book_ws.backend.command.DeleteBookCommand;
import com.ahmed.book_ws.backend.command.UpdateBookCommand;

import com.ahmed.common.BookInfo;
import com.ahmed.common.events.BookAddedEvent;
import com.ahmed.common.events.BookEditedEvent;
import com.ahmed.common.events.BookRemovedEvent;
import io.eventuate.*;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookAggregate extends ReflectiveMutableCommandProcessingAggregate<BookAggregate, BookCommand> {
    private BookInfo bookInfo;
    private boolean deleted = false;



   public List<Event> proccess(CreateBookCommand cmd){
       if (!this.deleted) {
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
    public void apply(BookAddedEvent event) {
        this.bookInfo = event.getInfo();
    }

    public void apply(BookEditedEvent event) {
        this.bookInfo = event.getInfo();
    }

    public void apply(BookRemovedEvent event) {
        this.deleted = true;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }
}
