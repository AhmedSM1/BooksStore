package com.ahmed.book_ws.backend.Service;

import com.ahmed.book_ws.backend.BookAggregate;
import com.ahmed.book_ws.backend.Model.BookRequestModel;
import io.eventuate.EntityWithIdAndVersion;

import java.util.concurrent.CompletableFuture;

public interface BookService {
    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> createBook(BookRequestModel requestModel);
    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> updateBook(BookDTO bookDTO);
    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> deleteBook(String id);


}
