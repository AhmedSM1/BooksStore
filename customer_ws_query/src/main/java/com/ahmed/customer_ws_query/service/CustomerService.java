package com.ahmed.customer_ws_query.service;

import com.ahmed.common.customers.CustomerInfo;
import com.ahmed.customer_ws_query.data.CustomerEntity;

import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerEntity entity);
    void updateCustomer(String customerId, CustomerInfo info);
    void deleteCustomer(String customerId);

    CustomerEntity findById(String customerId);

    List<CustomerEntity> getAllCustomers();
}
