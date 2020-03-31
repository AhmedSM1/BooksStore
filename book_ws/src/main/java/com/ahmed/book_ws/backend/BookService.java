package com.ahmed.book_ws.backend;

import com.ahmed.common.books.Book;
import com.ahmed.common.books.BookInfo;
import io.eventuate.EntityWithIdAndVersion;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface BookService {
    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> createBook(BookInfo info);
    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> updateBook(String id , BookInfo info);
    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> deleteBook(String id);


}
