package com.ahmed.customer_ws.controller;


import com.ahmed.customer_ws.aggregate.Customer;
import com.ahmed.common.customers.CustomerInfo;
import com.ahmed.customer_ws.model.CustomerResponse;
import com.ahmed.customer_ws.service.CustomerService;
import io.eventuate.EntityNotFoundException;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody  CustomerInfo info){
        EntityWithIdAndVersion<Customer> customer = service.createCustomer(info);
        return new ResponseEntity<>(new CustomerResponse(customer.getEntityId()),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{customerId}",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable String customerId,@RequestBody CustomerInfo info) {
        EntityWithIdAndVersion<Customer> customer = service.updateCustomer(customerId, info);
        return new ResponseEntity<>(new CustomerResponse(customer.getEntityId()),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable String customerId){
        EntityWithIdAndVersion<Customer> customer = service.deleteCustomer(customerId);
        return new ResponseEntity<>(new CustomerResponse(customer.getEntityId()),HttpStatus.ACCEPTED);
    }
}
