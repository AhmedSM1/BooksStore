package com.ahmed.order_ws.backend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", updatable = false, nullable = false)
    private Long orderID;

    
    @JsonFormat(pattern = "dd/MM/yyyy") 
    private LocalDate dateCreated;

    
    @Valid
    private List<OrderItem> ordersItems = new ArrayList<>();

    @Column(name = "TOTAL_ORDER_PRICE", nullable = false)
    private double totalOrderPrice;

    
    public void dismissChild(OrderItem item) {
        this.ordersItems.remove(item);
    }

    @PreRemove
    public void dismissChild() {
        this.



        this.cartItem.forEach(CartItem::dismissParent); // SYNCHRONIZING THE OTHER SIDE OF RELATIONSHIP
        this.cartItem.clear();
    }

   

    
}
