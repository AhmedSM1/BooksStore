package com.ahmed.book_ws.backend.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
public class BookEntity implements Serializable {
        @Id
        @GeneratedValue
        private String bookId;

       @Column(nullable = false, length = 25)
        private String bookTitle;

       @Column(nullable = false, length = 50)
        private String description;

       @Column(nullable = false)
        private double price;

       @Column(nullable = false)
        private int availableItemCount;

   public BookEntity(String bookId, String bookTitle, String description, double price, int availableItemCount){
       this.bookId = bookId;
       this.bookTitle = bookTitle;
       this.description = description;
       this.price = price;
       this.availableItemCount = availableItemCount;
   }

    public BookEntity() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
            return bookTitle;
        }

        public void setBookTitle(String bookTitle) {
            this.bookTitle = bookTitle;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getAvailableItemCount() {
            return availableItemCount;
        }

        public void setAvailableItemCount(int availableItemCount) {
            this.availableItemCount = availableItemCount;
        }



}
