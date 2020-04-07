package com.ahmed.customer_ws.controller;


import com.ahmed.customer_ws.domain.Customer;
import com.ahmed.customer_ws.model.CreateCustomerRequest;
import com.ahmed.customer_ws.model.CustomerInfo;
import com.ahmed.customer_ws.model.CustomerResponse;
import com.ahmed.customer_ws.service.CustomerService;
import io.eventuate.EntityNotFoundException;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
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

    @PostMapping
    public CustomerResponse createCustomers(@RequestBody CreateCustomerRequest request){
        CustomerInfo info = new CustomerInfo(request.getFirstName(),request.getLastName(),request.getEmail());

        EntityWithIdAndVersion<Customer> customer = service.createCustomer(info);
        return new CustomerResponse(customer.getEntityId());
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable String customerId){
        EntityWithMetadata<Customer> customerWithMetadata;
        try {
            customerWithMetadata = service.findById(customerId);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CustomerResponse response =
                new CustomerResponse(customerWithMetadata.getEntityIdAndVersion().getEntityId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
