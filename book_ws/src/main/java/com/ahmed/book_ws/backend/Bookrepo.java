package com.ahmed.book_ws.backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepo extends JpaRepository<Book,String>{
    
}