package com.ahmed.book_ws.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "books")
public class Book  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID", updatable = false, nullable = false)
    private Long bookId;

    @Column(name = "BOOk_TITLE", nullable = false)
    private String bookTitle;

    @Column(name = "BOOK_DESCRIPTION")
    private String description;

    private double price;

   @Column(name = "BOOK_CATEGORY")
    @Enumerated(EnumType.STRING)
    private BookCategory bookcatagory;

   @Column(name = "available_item_count")
    private int availableItemCount;

    public Book(BookInfo info) {
       this.bookTitle = info.getBookTitle();
       this.description = info.getDescription();
       this.price = info.getPrice();
       this.bookcatagory = info.getBookcatagory();
       this.availableItemCount = info.getAvailableItemCount();
    }

    public Book() {
    }

    public Book(Long bookId,String bookTitle,String description,double price,BookCategory bookcatagory,int availableItemCount) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.description = description;
        this.price = price;
        this.bookcatagory = bookcatagory;
        this.availableItemCount = availableItemCount;
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

    public BookCategory getBookcatagory() {
        return bookcatagory;
    }

    public void setBookcatagory(BookCategory bookcatagory) {
        this.bookcatagory = bookcatagory;
    }

    public int getAvailableItemCount() {
        return availableItemCount;
    }

    public void setAvailableItemCount(int availableItemCount) {
        this.availableItemCount = availableItemCount;
    }
}


