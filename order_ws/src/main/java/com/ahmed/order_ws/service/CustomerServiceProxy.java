package com.ahmed.order_ws.service;

import com.ahmed.order_ws.model.CustomerResponseModel;
import com.ahmed.order_ws.util.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class CustomerServiceProxy implements CustomerServiceRestTemplete {
    private RestTemplate restTemplate;

    public static final String CUSTOMER_WS_URL = "http://localhost:8013/customers/%s";

    private String customerServiceUrl;

    public void setCustomerServiceUrl(String customerServiceUrl) {
        this.customerServiceUrl = customerServiceUrl;
    }

    public CustomerServiceProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public CustomerResponseModel getCustomer(String customerId) {
        customerServiceUrl = String.format(CUSTOMER_WS_URL,customerId);
        CustomerResponseModel res  = restTemplate.getForObject(customerServiceUrl,CustomerResponseModel.class);

        return  res;
    }
}

