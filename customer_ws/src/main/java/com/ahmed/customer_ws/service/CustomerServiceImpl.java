package com.ahmed.customer_ws.service;


import com.ahmed.customer_ws.domain.CreateCustomerCommand;
import com.ahmed.customer_ws.domain.Customer;
import com.ahmed.customer_ws.domain.CustomerCommand;
import com.ahmed.customer_ws.model.CustomerInfo;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
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
    public EntityWithMetadata<Customer> findById(String customerId) {
        return customerRepository.find(customerId);
    }


}
