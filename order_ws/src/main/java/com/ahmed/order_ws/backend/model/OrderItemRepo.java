package com.ahmed.order_ws.backend.model;

import com.ahmed.common.order.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderBook,Long>{

}
