package com.ahmed.book_ws.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "BOOK_ID", updatable = false, nullable = false)
    private String bookId;

    @Column(name = "BOOk_TITLE", nullable = false)
    private String bookTitle;

    
    
    private Author author;


    @Column(name = "BOOK_DESCRIPTION")
    private String description;

    private double price;

    @Column(name = "BOOK_CATEGORY")
    @Enumerated(EnumType.STRING)
    private  BookCategory bookcatagory;

    @Column(name = "available_item_count")
    private int availableItemCount;

   
}


