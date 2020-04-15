package com.ahmed.books_ws.service;

import com.ahmed.books_ws.aggregate.Books;
import com.ahmed.common.books.BookInfo;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;

import java.util.concurrent.CompletableFuture;


public interface BookService {
    CompletableFuture<EntityWithIdAndVersion<Books>> createBook(BookInfo info);


    CompletableFuture<EntityWithIdAndVersion<Books>> deleteBook(String bookId);

    CompletableFuture<EntityWithIdAndVersion<Books>> updateBook(String bookId, BookInfo info);
}