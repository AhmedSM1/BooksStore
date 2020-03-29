package com.ahmed.book_ws.backend;

import com.ahmed.book_ws.backend.command.BookCommand;
import com.ahmed.book_ws.backend.command.CreateBookCommand;
import com.ahmed.book_ws.backend.command.DeleteBookCommand;
import com.ahmed.book_ws.model.BookInfo;
import com.ahmed.common.book.CreateBookEvent;
import com.ahmed.common.book.DeleteBookEvent;


import io.eventuate.*;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

import java.util.Collections;
import java.util.List;

public class BookAggregate extends ReflectiveMutableCommandProcessingAggregate<BookAggregate, BookCommand> {
               BookInfo bookInfo;
               Boolean deleted;


   public List<Event> proccess(CreateBookCommand cmd){
       if (this.deleted) {
           return Collections.emptyList();
       }
       return EventUtil.events(new CreateBookEvent());
   }

   public  List<Event> proccess(DeleteBookCommand cmd){
       if (this.deleted) {
           return Collections.emptyList();
       }
       return EventUtil.events(new DeleteBookEvent());
   }
}
