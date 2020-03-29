package com.ahmed.order_ws.backend.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderItem {

    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ORDER_ITEM_ID", updatable = false, nullable = false)
    private String orderItemId;
    
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    @JsonIgnore
    private Order order;
    
    @Column(name = "BOOK_ID", nullable = false)
    private String bookId;
    
    private int quantity;
    
    @Column(name = "ORDER_BOOK_PRICE", nullable = false)
    private double orderBookPrice;
    

     
}
