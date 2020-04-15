package com.ahmed.books_ws_query.controller;

import com.ahmed.books_ws_query.controller.dto.BookResponse;
import com.ahmed.books_ws_query.data.BookEntity;
import com.ahmed.books_ws_query.model.BookModel;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BooksQueryController {

    @Autowired
    BookService service;

    @GetMapping(value = "/{bookId}")
    public ResponseEntity<BookResponse> findBook(@PathVariable(value = "bookId") String bookId){
       BookModel model = service.findById(bookId);

        return new ResponseEntity<>(new BookResponse(model.getBookId(), model.getTitle(), model.getDescription(),
                model.getPrice(), model.getStatus()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return new ResponseEntity<>(service.getAllBooks().stream().map(model -> new BookResponse(
                model.getBookId(), model.getTitle(), model.getDescription(),
                model.getPrice(), model.getStatus()))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

}
