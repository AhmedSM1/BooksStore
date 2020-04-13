package com.ahmed.books_ws_query.data;


import com.ahmed.common.books.BookStatus;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Objects;

@Document
public class BookEntity {

    @Id
    private String bookId;

    private String title;
    private String description;
    private double price;
    private BookStatus status;

    public BookEntity(String bookId, String title, String description, double price, BookStatus status) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public BookEntity() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(bookId, that.bookId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, description, price, status);
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
