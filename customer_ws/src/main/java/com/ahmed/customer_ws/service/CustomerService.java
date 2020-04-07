package com.ahmed.customer_ws.service;

import com.ahmed.customer_ws.domain.Customer;
import com.ahmed.customer_ws.model.CustomerInfo;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;

public interface CustomerService {
    EntityWithIdAndVersion<Customer> createCustomer(CustomerInfo info);
    EntityWithMetadata<Customer> findById(String customerId);
}
