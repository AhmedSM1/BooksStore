package com.ahmed.order_ws.backend.model;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderBook {

    @EmbeddedId
    @JsonIgnore
    private OrderBookPK primaryKey;

    @Column(nullable = false)
    private Integer quantity;

    private double price;
}

