package com.main.books_ws_query.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<BookEntity,String> {
}
