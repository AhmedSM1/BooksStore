package com.ahmed.common.events;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRemovedEvent implements BookEvent {
    Long id;
}
