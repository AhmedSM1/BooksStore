package com.ahmed.book_ws.web;


import com.ahmed.book_ws.backend.Model.UpdateBookRequest;
import com.ahmed.book_ws.backend.BookAggregate;
import com.ahmed.book_ws.backend.Model.BookRepo;
import com.ahmed.book_ws.backend.Service.BookDTO;
import com.ahmed.book_ws.backend.Service.BookService;
import com.ahmed.book_ws.backend.Model.BookRequestModel;
import com.ahmed.book_ws.backend.Model.BookResponse;
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
    public CompletableFuture<BookResponse> saveBook(@Validated @RequestBody BookRequestModel bookInfo){
        log.debug("BookController.saveBook "+ bookInfo.getBookTitle());
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        BookDTO dto = modelMapper.map(bookInfo,BookDTO.class);

        return bookService.createBook(dto).thenApply(this ::makeBookResponse);

    }

    @DeleteMapping("/{bookId}")
    public CompletableFuture<BookResponse> deleteBook(@Validated @PathVariable String bookId){
        log.debug("BookController.deleteBook "+ bookId);

        return bookService.deleteBook(bookId).thenApply(this::makeBookResponse);
    }
   @PutMapping(  consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
                 produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
   public CompletableFuture<BookResponse> updateBook(@Validated @RequestBody UpdateBookRequest updateBookRequest){
       log.debug("BookController.updateBook "+ updateBookRequest.getBookTitle());

       ModelMapper modelMapper = new ModelMapper();

       modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

       BookDTO dto = modelMapper.map(updateBookRequest,BookDTO.class);
       return bookService.updateBook(dto).thenApply(this::makeBookResponse);
   }


    private BookResponse makeBookResponse(EntityWithIdAndVersion<BookAggregate> e) {
        return new BookResponse(e.getEntityId(),
                e.getAggregate().getDto().getBookTitle(),
                e.getAggregate().getDto().getDescription(),
                e.getAggregate().getDto().getPrice(),
                e.getAggregate().getDto().getAvailableItemCount());
    }
}
