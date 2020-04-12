package com.ahmed.books_ws_query.service;

import com.ahmed.books_ws_query.data.BookEntity;
import com.ahmed.books_ws_query.data.BookRepo;
import com.ahmed.common.books.BookInfo;
import com.ahmed.books_ws_query.util.BookNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            BookEntity entity = findById(bookId);
            entity.setTitle(details.getTitle());
            entity.setDescription(details.getDescription());
            entity.setAvailableItemCount(details.getAvailableItemCount());
            entity.setPrice(details.getPrice());
            this.repo.save(entity);

    }

    @Override
    public void deleteBook(String bookId) {
       BookEntity entity = findById(bookId);
       this.repo.delete(entity);
    }

    @Override
    public BookEntity findById(String bookId) {
     return  this.repo.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return this.repo.findAll();
    }


}
