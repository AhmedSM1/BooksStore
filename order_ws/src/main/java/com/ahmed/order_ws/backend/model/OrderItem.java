package com.ahmed.order_ws.backend.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private String  orderItemId;

    
     @Column(nullable = false) 
      private Integer quantity;
    
     
      @EmbeddedId
      @JsonIgnore
      private OrderItemPK primaryKey;

      




      public String getOrderItemId() {
          return orderItemId;
      }

      public void setOrderItemId(String orderItemId) {
          this.orderItemId = orderItemId;
      }

      public Integer getQuantity() {
          return quantity;
      }

      public void setQuantity(Integer quantity) {
          this.quantity = quantity;
      }

      @JsonIgnore
      public OrderItemPK getPrimaryKey() {
          return primaryKey;
      }

      public void setPrimaryKey(OrderItemPK primaryKey) {
          this.primaryKey = primaryKey;
      }

      public OrderItem() {
      super();
    }

    public OrderItem(Order order,String itemid,Integer quantity){
        this.primaryKey = new OrderItemPK();
        primaryKey.setOrder(order);
        primaryKey.setBookId(itemid);
        this.quantity = quantity;
    }



     
}
