package com.ahmed.books_ws.controller;


import com.ahmed.books_ws.domain.Books;
import com.ahmed.books_ws.model.BookInfo;
import com.ahmed.books_ws.model.BookResponseModel;
import com.ahmed.books_ws.service.BookService;
import io.eventuate.EntityNotFoundException;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<BookResponseModel> createBook(@RequestBody BookInfo info){
        EntityWithIdAndVersion<Books> book = service.createBook(info);
        String id = book.getEntityId();
        BookResponseModel res = new BookResponseModel(id);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponseModel> getBook(@PathVariable String bookId){
        EntityWithMetadata<Books> bookWithMetadata;
        try {
            bookWithMetadata = service.findById(bookId);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BookResponseModel response =
                new BookResponseModel(bookWithMetadata.getEntityIdAndVersion().getEntityId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
