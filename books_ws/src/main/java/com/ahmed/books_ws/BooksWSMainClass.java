package com.ahmed.books_ws;


import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class BooksWSMainClass {
    public static void main(String[] args) {
        SpringApplication.run(BooksWSMainClass.class,args);
    }
}
