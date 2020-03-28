package com.ahmed.book_ws.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {

    private String bookTitle;
    private String bookDescription;
    private BookCategory bookCategory;
    private  double price;
    private  int count;

}
