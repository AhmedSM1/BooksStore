package com.ahmed.common.customers;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.ahmed.customer_ws.aggregate.Customer")
public interface CustomerEvent extends Event {
}
