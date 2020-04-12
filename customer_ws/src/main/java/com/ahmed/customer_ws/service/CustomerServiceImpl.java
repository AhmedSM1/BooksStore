package com.ahmed.customer_ws.service;


import com.ahmed.customer_ws.command.CreateCustomerCommand;
import com.ahmed.customer_ws.aggregate.Customer;
import com.ahmed.customer_ws.command.CustomerCommand;
import com.ahmed.common.customers.CustomerInfo;
import com.ahmed.customer_ws.command.DeleteCustomerCommand;
import com.ahmed.customer_ws.command.UpdateCustomerCommand;
import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;

import java.util.concurrent.CompletableFuture;

public class CustomerServiceImpl implements CustomerService {
    private AggregateRepository<Customer, CustomerCommand> customerRepository;

    public CustomerServiceImpl(AggregateRepository<Customer, CustomerCommand> customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Customer>> createCustomer(CustomerInfo info) {
        return customerRepository.save(new CreateCustomerCommand(info));
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Customer>> updateCustomer(String customerId, CustomerInfo info) {
        return customerRepository.update(customerId,new UpdateCustomerCommand(info));
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Customer>> deleteCustomer(String customerId) {
        return customerRepository.update(customerId,new DeleteCustomerCommand(customerId));
    }




}
