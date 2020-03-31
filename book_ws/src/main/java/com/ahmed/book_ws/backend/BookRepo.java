package com.ahmed.book_ws.backend;



import com.ahmed.common.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Long>{



}