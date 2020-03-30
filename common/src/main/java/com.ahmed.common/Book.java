package com.ahmed.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long bookId;

        private String bookTitle;

        private String description;

        private double price;

        private int availableItemCount;

    public Book(BookInfo info) {
        this.bookId = getBookId();
        this.bookTitle = info.getBookTitle();
        this.description = info.getDescription();
        this.price = info.getPrice();
        this.availableItemCount = info.getAvailableItemCount();
    }

    public Book() {
    }

    public Long getBookId() {
            return bookId;
        }

        public void setBookId(Long bookId) {
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
