package com.ahmed.order_ws.backend.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo  extends JpaRepository<Order,Long>{

}
