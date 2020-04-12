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

import java.util.concurrent.CompletableFuture;

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
    public CompletableFuture<ResponseEntity<CustomerResponse>> createCustomer(@RequestBody  CustomerInfo info){
        return this.service.createCustomer(info)
                .thenApply(res->new ResponseEntity<>(new CustomerResponse(res.getEntityId()), HttpStatus.CREATED));
    }

    @PutMapping(value = "/{customerId}",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public  CompletableFuture<ResponseEntity<CustomerResponse>>  updateCustomer(@PathVariable String customerId,@RequestBody CustomerInfo info) {
        return this.service.updateCustomer(customerId,info)
                .thenApply(res->new ResponseEntity<>(new CustomerResponse(res.getEntityId()), HttpStatus.ACCEPTED));
    }

    @DeleteMapping(value = "/{customerId}")
    public  CompletableFuture<ResponseEntity<CustomerResponse>>  deleteCustomer(@PathVariable String customerId){
        return this.service.deleteCustomer(customerId)
                .thenApply(res->new ResponseEntity<>(new CustomerResponse(res.getEntityId()), HttpStatus.ACCEPTED));
    }
}
