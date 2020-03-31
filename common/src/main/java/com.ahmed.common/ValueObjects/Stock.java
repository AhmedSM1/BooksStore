package com.ahmed.common.ValueObjects;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


//Value object doesnt have an id
public class Stock {
    private Integer books;

    public Stock() {
    }

    public Stock(Integer books) {
        this.books = books;
    }

    public Integer getBooks() {
        return books;
    }

    public void setBooks(Integer books) {
        this.books = books;
    }
     /*
  If this >= other
   */
     public Boolean booksOrderdIsGraterThanOrEqual(Stock other){
         return books.equals(other.books);
     }
     public Stock add(Stock other){
         return new Stock(books += other.books);
     }

    public Stock suptract(Stock other){
        return new Stock(books -= other.books);
    }


    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
