package com.ahmed.book_ws.backend;



import com.ahmed.common.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,String>{

    Book save(Book book);

    Book findById(Long bookId);

    List<Book> findAll();
}