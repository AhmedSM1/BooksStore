package com.ahmed.books_ws_query.controller;

import com.ahmed.books_ws_query.data.BookEntity;
import com.ahmed.books_ws_query.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksQueryController {

    @Autowired
    BookService service;

    @GetMapping(value = "/{bookId}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BookEntity> findBook(@PathVariable(value = "bookId") String bookId){
       BookEntity entity =  service.findById(bookId);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks(){
        List<BookEntity> list = service.getAllBooks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
