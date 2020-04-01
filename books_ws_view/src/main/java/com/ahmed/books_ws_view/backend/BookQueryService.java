package com.ahmed.books_ws_view.backend;

import java.util.List;

public interface BookQueryService {
    BookInfo findByBookId(String id);
    List<BookInfo> findByBookTitle(String title);
    Iterable<BookInfo> getAllBooks();
}
