package com.ahmed.book_ws.backend.Service;

import com.ahmed.book_ws.backend.Model.BookRepo;
import com.ahmed.book_ws.backend.BookAggregate;
import com.ahmed.book_ws.backend.Model.BookRequestModel;
import com.ahmed.book_ws.backend.command.BookCommand;
import com.ahmed.book_ws.backend.command.CreateBookCommand;
import com.ahmed.book_ws.backend.command.DeleteBookCommand;
import com.ahmed.book_ws.backend.command.UpdateBookCommand;
import com.ahmed.book_ws.backend.Model.BookEntity;
import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
@Service
public class BookService {

    private final AggregateRepository<BookAggregate, BookCommand> aggRepository;
    private BookRepo repo;
    private static Logger log = LoggerFactory.getLogger(BookService.class);

    @Autowired
    public BookService(AggregateRepository<BookAggregate, BookCommand> repository, BookRepo repo )  {
        this.aggRepository = repository;
        this.repo = repo;
    }



    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> createBook(BookRequestModel info) {
        log.debug("Book service   Saving: "+info);

        //persist to DB
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        BookDTO dto = modelMapper.map(info,BookDTO.class);
        dto.setBookId(UUID.randomUUID().toString());
        BookEntity entity = modelMapper.map(dto, BookEntity.class);

        repo.save(entity);
        log.debug("Book id is "+entity.getBookId());


        return aggRepository.save(new CreateBookCommand(dto));
    }


    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> updateBook(BookDTO info) {
        String bookId = info.getBookId();
        log.debug("Book service   updating: "+bookId);
        BookEntity book = repo.findById(bookId).orElseThrow(() -> new RuntimeException("Book Id doesn't exist!"));
        //update the book entity and presist it to the database
        book.setBookTitle(info.getBookTitle());
        book.setDescription(info.getDescription());
        book.setAvailableItemCount(info.getAvailableItemCount());
        book.setPrice(info.getPrice());

        repo.save(book);

        return aggRepository.save(new UpdateBookCommand(info));
    }


    public CompletableFuture<EntityWithIdAndVersion<BookAggregate>> deleteBook(String id) {
        log.debug("Book service   Deleting: "+id);
        BookEntity book = repo.findById(id).orElseThrow(() -> new RuntimeException("Book Id doesn't exist!"));
        log.debug("BookController.deleteBook title"+ book.getBookTitle());
        repo.delete(book);
        return aggRepository.update(id, new DeleteBookCommand(id));
    }



}
