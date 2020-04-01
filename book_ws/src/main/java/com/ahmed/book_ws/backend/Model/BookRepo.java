package com.ahmed.book_ws.backend.Model;



import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity,String>{


}