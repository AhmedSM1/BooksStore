package com.ahmed.book_ws.backend.model;



import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepo extends JpaRepository<Book,String>{
    
}