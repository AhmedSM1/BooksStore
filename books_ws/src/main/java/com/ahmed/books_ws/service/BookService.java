package com.ahmed.books_ws.service;

import com.ahmed.books_ws.domain.Books;
import com.ahmed.books_ws.model.BookInfo;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;



public interface BookService {
    EntityWithIdAndVersion<Books> createBook( BookInfo info);

    EntityWithMetadata<Books> findById(String bookId);
}
