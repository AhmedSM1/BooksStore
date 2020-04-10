package com.ahmed.customer_ws.service;

import com.ahmed.customer_ws.aggregate.Customer;
import com.ahmed.common.customers.CustomerInfo;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;

public interface CustomerService {
    EntityWithIdAndVersion<Customer> createCustomer(CustomerInfo info);
    EntityWithIdAndVersion<Customer> updateCustomer(String customerId,CustomerInfo info);
    EntityWithIdAndVersion<Customer> deleteCustomer(String customerId);
}
