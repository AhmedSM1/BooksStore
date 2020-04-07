package com.ahmed.books_ws.domain;

import com.ahmed.common.ValueObjects.Stock;
import com.ahmed.common.books.BookCreatedEvent;
import com.ahmed.common.books.BookEditedEvent;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

import java.util.List;

public class Books extends ReflectiveMutableCommandProcessingAggregate<Books,BooksCommand> {
   private String title;
   private String description;
   private double price;
   private Stock availableItemCount;


    public List<Event> process(CreateBookCommand cmd) {
         title = cmd.getInfo().getTitle();
        description = cmd.getInfo().getDescription();
        price = cmd.getInfo().getPrice();
        availableItemCount = cmd.getInfo().getAvailableItemCount();
        return EventUtil.events(new BookCreatedEvent(title,description,price,availableItemCount));
    }
    public void apply(BookCreatedEvent event) {
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.availableItemCount = event.getAvailableItemCount();
    }

    public List<Event> process(UpdateBookCommand cmd) {
        title = cmd.getInfo().getTitle();
        description = cmd.getInfo().getDescription();
        price = cmd.getInfo().getPrice();
        availableItemCount = cmd.getInfo().getAvailableItemCount();
        return EventUtil.events(new BookEditedEvent(title,availableItemCount,price,description));
    }
    public void apply(BookEditedEvent event) {
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.availableItemCount = event.getStock();
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Stock getAvailableItemCount() {
        return availableItemCount;
    }
}
