package com.ahmed.customer_ws.service;


import com.ahmed.customer_ws.command.CreateCustomerCommand;
import com.ahmed.customer_ws.aggregate.Customer;
import com.ahmed.customer_ws.command.CustomerCommand;
import com.ahmed.common.customers.CustomerInfo;
import com.ahmed.customer_ws.command.DeleteCustomerCommand;
import com.ahmed.customer_ws.command.UpdateCustomerCommand;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.sync.AggregateRepository;

public class CustomerServiceImpl implements CustomerService {
    private final AggregateRepository<Customer, CustomerCommand> customerRepository;

    public CustomerServiceImpl(AggregateRepository<Customer, CustomerCommand> customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public EntityWithIdAndVersion<Customer> createCustomer(CustomerInfo info) {
        return customerRepository.save(new CreateCustomerCommand(info));
    }

    @Override
    public EntityWithIdAndVersion<Customer> updateCustomer(String customerId, CustomerInfo info) {
        return customerRepository.update(customerId,new UpdateCustomerCommand(info));
    }

    @Override
    public EntityWithIdAndVersion<Customer> deleteCustomer(String customerId) {
        return customerRepository.update(customerId,new DeleteCustomerCommand(customerId));
    }




}
