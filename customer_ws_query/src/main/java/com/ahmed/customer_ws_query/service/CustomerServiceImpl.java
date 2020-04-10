package com.ahmed.customer_ws_query.service;

import com.ahmed.common.customers.CustomerInfo;
import com.ahmed.customer_ws_query.data.CustomerEntity;
import com.ahmed.customer_ws_query.data.CustomerRepo;
import com.ahmed.customer_ws_query.util.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepo repo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo repo) {
        this.repo = repo;
    }

    @Override
    public void createCustomer(CustomerEntity entity) {
        this.repo.save(entity);
    }

    @Override
    public void updateCustomer(String customerId, CustomerInfo info) {
        CustomerEntity entity = findById(customerId);
        entity.setFirstName(info.getFirstName());
        entity.setLastName(info.getLastName());
        entity.setEmail(info.getEmail());
        this.repo.save(entity);
    }

    @Override
    public void deleteCustomer(String customerId) {
        CustomerEntity entity = findById(customerId);
        this.repo.delete(entity);
    }

    @Override
    public CustomerEntity findById(String customerId) {
        return this.repo.findById(customerId).orElseThrow( CustomerNotFoundException::new);
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
      return   this.repo.findAll();
    }
}
