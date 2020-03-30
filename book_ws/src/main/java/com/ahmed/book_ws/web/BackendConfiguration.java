package com.ahmed.book_ws.web;


import com.ahmed.book_ws.backend.BookAggregate;
import com.ahmed.book_ws.backend.BookService;
import com.ahmed.book_ws.backend.command.BookCommand;
import com.ahmed.common.Book;
import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BackendConfiguration {

    @Bean
    public AggregateRepository<BookAggregate, BookCommand> bookAggregateRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(BookAggregate.class, eventStore);
    }

    @Bean
    public BookService bookService(AggregateRepository<BookAggregate, BookCommand> bookAggregateRepository) {
        return new BookService(bookAggregateRepository);
    }
}
