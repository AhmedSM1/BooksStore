package com.ahmed.order_ws_query.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<OrderEntity,String> {
}
