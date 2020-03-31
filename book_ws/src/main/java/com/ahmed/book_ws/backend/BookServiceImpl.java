package com.ahmed.book_ws.backend;

import com.ahmed.book_ws.backend.command.BookCommand;
import com.ahmed.book_ws.backend.command.CreateBookCommand;
import com.ahmed.book_ws.backend.command.DeleteBookCommand;
import com.ahmed.book_ws.backend.command.UpdateBookCommand;
import com.ahmed.common.books.Book;
import com.ahmed.common.books.BookInfo;
import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
@Service
public class BookServiceImpl implements BookService {
    private final AggregateRepository<BookAggregate, BookCommand> aggRepository;
    private BookRepo repo;
    private static Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    public BookServiceImpl(AggregateRepository<BookAggregate, BookCommand> repository) {
        this.aggRepository = repository;
    }


    @Override
    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> createBook(BookInfo info) {
        log.debug("Book service   Saving: "+info);

        return aggRepository.save(new CreateBookCommand(info));
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> updateBook(String id, BookInfo info) {
        log.debug("Book service   updating: "+info);
        return aggRepository.save(new UpdateBookCommand(id, info));
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> deleteBook(String id) {
        log.debug("Book service   Deleting: "+id);
        return aggRepository.update(id, new DeleteBookCommand(id));
    }



}
