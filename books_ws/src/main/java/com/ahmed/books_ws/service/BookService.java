package com.ahmed.books_ws.service;

import com.ahmed.books_ws.aggregate.Books;
import com.ahmed.common.books.BookInfo;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;


public interface BookService {
    EntityWithIdAndVersion<Books> createBook(BookInfo info);

    EntityWithIdAndVersion<Books> deleteBook(String bookId);

    EntityWithMetadata<Books> findById(String bookId);

    EntityWithIdAndVersion<Books> updateBook(String bookId, BookInfo info);
}