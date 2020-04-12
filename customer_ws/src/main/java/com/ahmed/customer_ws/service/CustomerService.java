package com.ahmed.customer_ws.service;

import com.ahmed.customer_ws.aggregate.Customer;
import com.ahmed.common.customers.CustomerInfo;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;

import java.util.concurrent.CompletableFuture;

public interface CustomerService {
    CompletableFuture<EntityWithIdAndVersion<Customer>> createCustomer(CustomerInfo info);
    CompletableFuture<EntityWithIdAndVersion<Customer>>updateCustomer(String customerId,CustomerInfo info);
    CompletableFuture<EntityWithIdAndVersion<Customer>> deleteCustomer(String customerId);
}
