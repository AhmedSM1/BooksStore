package com.main.books_ws_query.service;

import com.ahmed.common.books.BookInfo;
import com.main.books_ws_query.data.BookEntity;
import com.main.books_ws_query.data.BookRepo;
import com.main.books_ws_query.util.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BookServiceImpl implements BookService {

     BookRepo repo;

    @Autowired
    public BookServiceImpl(BookRepo repo) {
        this.repo = repo;
    }


    @Override
    public void createBook(BookEntity createBook) {
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
