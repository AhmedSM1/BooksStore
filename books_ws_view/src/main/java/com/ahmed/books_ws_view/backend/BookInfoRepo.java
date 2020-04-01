package com.ahmed.books_ws_view.backend;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookInfoRepo  extends CrudRepository<BookInfo,String> {
    BookInfo findByBookId(String bookId);
    List<BookInfo> findByBookTitle(String bookTitle);
}
