package com.ahmed.book_ws.backend;

import com.ahmed.book_ws.backend.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepo extends JpaRepository<Book,String>{
    
}