package com.ahmed.books_ws.controller;


import com.ahmed.books_ws.aggregate.Books;
import com.ahmed.books_ws.model.CommandResponse;
import com.ahmed.books_ws.service.BookService;
import com.ahmed.common.books.BookInfo;
import io.eventuate.EntityWithIdAndVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CommandResponse> createBook(@RequestBody BookInfo info){
        EntityWithIdAndVersion<Books> book  =  bookService.createBook(info);
        return new ResponseEntity<>(new CommandResponse(book.getEntityId()), HttpStatus.CREATED);
        }


    @PutMapping(value = "/{bookId}",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CommandResponse> updateBook(@PathVariable String bookId,@RequestBody BookInfo info){
        EntityWithIdAndVersion<Books> book  = bookService.updateBook(bookId,info);
        return new ResponseEntity<>(new CommandResponse(book.getEntityId()), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{bookId}")
    public ResponseEntity<CommandResponse> updateBook(@PathVariable String bookId){
        EntityWithIdAndVersion<Books> book = bookService.deleteBook(bookId);
        return new ResponseEntity<>(new CommandResponse(book.getEntityId()), HttpStatus.OK);
    }
    }


