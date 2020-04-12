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
    private int availableItemCount;
    private BookStatus status;

    public BookEntity(String bookId,String title, String description, double price, int availableItemCount, BookStatus status) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.availableItemCount = availableItemCount;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Double.compare(that.price, price) == 0 &&
                availableItemCount == that.availableItemCount &&
                Objects.equals(bookId, that.bookId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, description, price, availableItemCount, status);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", availableItemCount=" + availableItemCount +
                ", status=" + status +
                '}';
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

    public int getAvailableItemCount() {
        return availableItemCount;
    }

    public void setAvailableItemCount(int availableItemCount) {
        this.availableItemCount = availableItemCount;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
