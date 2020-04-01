package com.ahmed.book_ws.backend;


import com.ahmed.book_ws.backend.Model.BookRepo;
import com.ahmed.book_ws.backend.Service.BookService;
import com.ahmed.book_ws.backend.command.BookCommand;
import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.ahmed.books-store")
@EnableJpaRepositories("com.ahmed.book_ws")
@EnableEventHandlers
public class BackendConfiguration {
    @Bean
    public BookWorkflow bookWorkflow() {
        return new BookWorkflow();
    }
    @Bean
    public AggregateRepository<BookAggregate, BookCommand> bookRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(BookAggregate.class, eventStore);
    }

    @Bean
    public BookService bookService(AggregateRepository<BookAggregate, BookCommand> bookAggregateRepository, BookRepo repo) {
        return new BookService(bookAggregateRepository,repo);
    }
}