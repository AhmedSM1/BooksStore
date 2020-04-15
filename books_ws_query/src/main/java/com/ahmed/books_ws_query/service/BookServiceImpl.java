package com.ahmed.books_ws_query.service;

import com.ahmed.books_ws_query.data.BookEntity;
import com.ahmed.books_ws_query.data.BookRepo;
import com.ahmed.books_ws_query.model.BookModel;
import com.ahmed.common.books.BookInfo;
import com.ahmed.books_ws_query.util.BookNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    @Autowired
     private BookRepo repo;
    Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);


    @Override
    public void createBook(BookEntity createBook) {
        logger.debug("Book query service_________create book()");

        this.repo.save(createBook);
    }

    @Override
    public void updateBook(String bookId, BookInfo details) {
            Optional<BookEntity> entity = this.repo.findById(bookId);
            if (entity.isPresent()){
                entity.get().setTitle(details.getTitle());
                entity.get().setDescription(details.getDescription());
                entity.get().setPrice(details.getPrice());
                this.repo.save(entity.get());
            }

    }

    @Override
    public void deleteBook(String bookId) {
//       BookEntity entity = repo.findById(bookId)
       this.repo.deleteById(bookId);
    }

    @Override
    public BookModel findById(String bookId) {
     BookEntity bookEntity =  this.repo.findById(bookId).orElseThrow(BookNotFoundException::new);
     return new BookModel(bookEntity.getBookId(), bookEntity.getTitle(),bookEntity.getDescription(),bookEntity.getPrice(),bookEntity.getStatus());
    }

    @Override
    public List<BookModel> getAllBooks() {
       List<BookEntity> bookEntities = repo.findAll();

      return bookEntities.stream().map(b->new BookModel(b.getBookId(), b.getTitle(),
              b.getDescription(), b.getPrice(), b.getStatus())).collect(Collectors.toList());


    }


}
