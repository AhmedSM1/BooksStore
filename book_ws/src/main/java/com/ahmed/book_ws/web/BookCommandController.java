package com.ahmed.book_ws.web;


import com.ahmed.book_ws.backend.BookAggregate;
import com.ahmed.book_ws.backend.BookRepo;
import com.ahmed.book_ws.backend.BookService;
import com.ahmed.common.books.Book;
import com.ahmed.common.books.BookInfo;
import com.ahmed.common.books.BookResponse;
import io.eventuate.EntityWithIdAndVersion;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/books")
public class BookCommandController {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepo repo;
    private static Logger log = LoggerFactory.getLogger(BookCommandController.class);

    @PostMapping(    consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
                     produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public CompletableFuture<BookResponse> saveBook(@Validated @RequestBody BookInfo bookInfo){
        log.debug("BookController.saveBook "+ bookInfo.getBookTitle());

        //persist to DB
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Book book = modelMapper.map(bookInfo,Book.class);
        repo.save(book);
        log.debug("Book id is "+book.getBookId());

       return bookService.createBook(bookInfo).thenApply(this ::makeBookResponse);

    }

   

    private BookResponse makeBookResponse(EntityWithIdAndVersion<BookAggregate> e) {
        return new BookResponse(e.getEntityId(),
                e.getAggregate().getBookInfo().getBookTitle(),
                e.getAggregate().getBookInfo().getDescription(),
                e.getAggregate().getBookInfo().getPrice(),
                e.getAggregate().getBookInfo().getAvailableItemCount());
    }
}
