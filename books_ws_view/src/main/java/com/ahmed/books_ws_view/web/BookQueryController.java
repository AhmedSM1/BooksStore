package com.ahmed.books_ws_view.web;


import com.ahmed.books_ws_view.backend.BookInfo;
import com.ahmed.books_ws_view.backend.BookQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookQueryController {
    private BookQueryServiceImpl service;

    @Autowired
    public BookQueryController(BookQueryServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookInfo> getBook(@PathVariable String bookId){
        BookInfo book = service.findByBookId(bookId);
        return ResponseEntity.ok().body(book);
    }
    @GetMapping("/{bookTitle}")
    public List<BookInfo> getBooksByTitle(@PathVariable String bookTitle){
        List<BookInfo> books = service.findByBookTitle(bookTitle);
        return books;
    }
    @GetMapping()
    public Iterable<BookInfo> getAll(){
        Iterable<BookInfo> books = service.getAllBooks();
        return books;
    }
}
