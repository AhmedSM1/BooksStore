package com.ahmed.common.order.events;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.ahmed.order_ws.aggregate.Order")
public interface OrderEvent extends Event {
}
