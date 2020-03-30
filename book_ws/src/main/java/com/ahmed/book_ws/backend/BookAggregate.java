package com.ahmed.book_ws.backend;

import com.ahmed.book_ws.backend.command.BookCommand;
import com.ahmed.book_ws.backend.command.CreateBookCommand;
import com.ahmed.book_ws.backend.command.DeleteBookCommand;
import com.ahmed.book_ws.backend.command.UpdateBookCommand;

import com.ahmed.book_ws.backend.events.CreateBookEvent;
import com.ahmed.book_ws.backend.events.DeleteBookEvent;
import com.ahmed.book_ws.backend.events.UpdateBookEvent;
import com.ahmed.book_ws.backend.model.BookInfo;

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
       return EventUtil.events(new CreateBookEvent(cmd.getInfo()));
   }
   public  List<Event> proccess(UpdateBookCommand cmd){
    if (this.deleted) {
        return Collections.emptyList();
    }
    return EventUtil.events(new UpdateBookEvent(cmd.getInfo()));
}

   public  List<Event> proccess(DeleteBookCommand cmd){
       if (this.deleted) {
           return Collections.emptyList();
       }
       return EventUtil.events(new DeleteBookEvent());
   }


}
