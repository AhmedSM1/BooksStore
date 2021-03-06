package com.ahmed.customer_ws_query.controller;


import com.ahmed.customer_ws_query.data.CustomerEntity;
import com.ahmed.customer_ws_query.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerQueryController {
    @Autowired
    CustomerService service;

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<CustomerEntity> findCustomer(@PathVariable(value = "customerId") String customerId){
        CustomerEntity entity =  service.findById(customerId);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAllCustomers(){
        List<CustomerEntity> list = service.getAllCustomers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
