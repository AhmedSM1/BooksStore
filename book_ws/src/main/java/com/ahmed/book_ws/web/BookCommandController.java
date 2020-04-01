package com.ahmed.book_ws.web;


import com.ahmed.book_ws.backend.Model.*;
import com.ahmed.book_ws.backend.Service.BookDTO;
import com.ahmed.book_ws.backend.Service.BookService;
import com.ahmed.common.book.CreateBookResponse;
import com.ahmed.common.book.DeleteBookResponse;
import com.ahmed.common.book.UpdatedBookResponse;
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
  private BookService service;
  private static Logger log = LoggerFactory.getLogger(BookCommandController.class);
    @Autowired
    public BookCommandController(BookService service) {
        this.service = service;
    }



    @PostMapping(    consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
                     produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public CompletableFuture<CreateBookResponse> saveBook(@Validated @RequestBody BookRequestModel bookInfo){
        log.debug("BookController.saveBook "+ bookInfo.getBookTitle());


        return service.createBook(bookInfo).thenApply(entityAndEventInfo -> new CreateBookResponse(entityAndEventInfo.getEntityId()));

    }

    @DeleteMapping("/{bookId}")
    public CompletableFuture<DeleteBookResponse> deleteBook(@Validated @PathVariable String bookId){
        log.debug("BookController.deleteBook "+ bookId);

        return service.deleteBook(bookId).thenApply(entityAndEventInfo -> new DeleteBookResponse(entityAndEventInfo.getEntityId()));
    }

   @PutMapping(  consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
                 produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
   public CompletableFuture<UpdatedBookResponse> updateBook(@Validated @RequestBody UpdateBookRequest updateBookRequest){
       log.debug("BookController.updateBook "+ updateBookRequest.getBookTitle());

       ModelMapper modelMapper = new ModelMapper();

       modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

       BookDTO dto = modelMapper.map(updateBookRequest,BookDTO.class);
       return service.updateBook(dto).thenApply(entityAndEventInfo -> new UpdatedBookResponse(entityAndEventInfo.getEntityId()));
   }


}
