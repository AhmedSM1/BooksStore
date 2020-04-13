package com.ahmed.common.books;


import java.util.Objects;

public class BookCreatedEvent implements BookEvent {

    private BookInfo info;
    private BookStatus bookStatus;

    public BookCreatedEvent(BookInfo info, BookStatus bookStatus) {
        this.info = info;
        this.bookStatus = bookStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCreatedEvent that = (BookCreatedEvent) o;
        return Objects.equals(info, that.info) &&
                bookStatus == that.bookStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, bookStatus);
    }

    public BookInfo getInfo() {
        return info;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }
}
