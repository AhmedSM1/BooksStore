package com.ahmed.order_ws.backend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "order")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="order_item")
public class Order {
    
    @Column(name = "ORDER_ID", updatable = false, nullable = false)
    private Long orderID;

    
    @JsonFormat(pattern = "dd/MM/yyyy") 
    private LocalDate dateCreated;

    
    @OneToMany(mappedBy = "primaryKey.cart")
    @Valid
    private List<OrderItem> ordersItems = new ArrayList<>();

    @Column(name = "TOTAL_ORDER_PRICE", nullable = false)
    private double totalOrderPrice;

    

   

    
}
