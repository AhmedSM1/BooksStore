package com.ahmed.common_backend.books.events;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = " com.ahmed.book_ws.backend.BookAggregate")
public interface BookEvent extends Event {
}
