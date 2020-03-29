package com.ahmed.common.book;

public class CreateBookEvent implements BookEvent{

    private  String bookTitle;
    private  String description;
    private double price;
    private BookCategory bookcatagory;
    private int availableItemCount;

    public enum BookCategory {
        Drama,
        Horror,
        Humor,
        Mystry,
        Fantasy,
        ScienceFiction;
    }

}
