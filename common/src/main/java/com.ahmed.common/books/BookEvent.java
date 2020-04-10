package com.ahmed.common.books;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.ahmed.books_ws.aggregate.Books")
public interface BookEvent extends Event {
}
