package com.ahmed.common.book;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = " com.ahmed.book_ws.backend.BookAggregate")
public interface BookEvent extends Event {
}
