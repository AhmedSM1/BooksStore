package com.ahmed.book_ws.backend.command;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteBookCommand implements  BookCommand {

    String bookId;
}
