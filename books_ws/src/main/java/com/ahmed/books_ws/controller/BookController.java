package com.ahmed.books_ws.controller;


import com.ahmed.books_ws.model.CommandResponse;
import com.ahmed.books_ws.service.BookService;
import com.ahmed.common.books.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public CompletableFuture<ResponseEntity<CommandResponse>> createBook(@RequestBody BookInfo info){
        return this.bookService.createBook(info)
                .thenApply(res->new ResponseEntity<>(new CommandResponse(res.getEntityId()), HttpStatus.CREATED));
        }


    @PutMapping(value = "/{bookId}")
    public CompletableFuture<ResponseEntity<CommandResponse>> updateBook(@PathVariable(value = "bookId") String bookId,@RequestBody BookInfo info){
        return this.bookService.updateBook(bookId,info)
                .thenApply(res-> new ResponseEntity<>(new CommandResponse(res.getEntityId()), HttpStatus.ACCEPTED));
    }

    @DeleteMapping(value = "/{bookId}")
    public CompletableFuture<ResponseEntity<CommandResponse>> updateBook(@PathVariable(value = "bookId") String bookId){
        return this.bookService.deleteBook(bookId)
                .thenApply(res->new ResponseEntity<>(new CommandResponse(res.getEntityId()), HttpStatus.ACCEPTED));

    }
    }


