package com.ahmed.book_ws.backend;

import com.ahmed.book_ws.backend.command.BookCommand;
import com.ahmed.book_ws.backend.command.CreateBookCommand;
import com.ahmed.book_ws.backend.command.DeleteBookCommand;
import com.ahmed.book_ws.backend.command.UpdateBookCommand;
import com.ahmed.common.BookInfo;
import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
@Service
public class BookService {
    private final AggregateRepository<BookAggregate, BookCommand> repository;

    public BookService(AggregateRepository<BookAggregate, BookCommand> repository) {
        this.repository = repository;
    }

    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> createBook(BookInfo info) {
        return repository.save(new CreateBookCommand(info));
    }

    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> updateBook(Long id , BookInfo info) {
        return repository.save(new UpdateBookCommand(id, info));
    }


    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> deleteBook(String id) {
        return repository.update(id, new DeleteBookCommand());
    }
}
