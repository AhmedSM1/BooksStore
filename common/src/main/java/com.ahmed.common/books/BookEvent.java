package com.ahmed.common.books;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.ahmed.books_ws.domain.Books")
public interface BookEvent extends Event {
}
