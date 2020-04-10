package com.ahmed.customer_ws_query.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<CustomerEntity,String> {
}
