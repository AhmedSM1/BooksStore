package com.ahmed.order_ws.service;

import com.ahmed.order_ws.model.Customer;
import com.ahmed.order_ws.model.CustomerResponseModel;
import com.ahmed.order_ws.util.CustomerNotFoundException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class CustomerServiceProxy implements CustomerServiceRestTemplete {

    private RestTemplate restTemplate;
    public static final String CUSTOMER_WS_URL = "http://CUSTOMER_WS_QUERY/customers/%s";

    private String customerServiceUrl;

    public CustomerServiceProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void verifyCustomerCustomerId(String customerId) {
      customerServiceUrl = String.format(CUSTOMER_WS_URL,customerId);
        ResponseEntity<Customer> result = null;
        try {
            result = restTemplate.getForEntity(customerServiceUrl, Customer.class, customerId);

        } catch (HttpClientErrorException e) {
            switch (e.getStatusCode()) {
                case NOT_FOUND:
                    throw new CustomerNotFoundException();
                default:
                    unrecognizedStatusCode(customerId, e.getStatusCode());
            }
        }
        switch (result.getStatusCode()) {
            case OK:
                return;
            case NOT_FOUND:
                throw new CustomerNotFoundException();
            default:
                unrecognizedStatusCode(customerId, result.getStatusCode());
        }
    }

    private void unrecognizedStatusCode(String customerId, HttpStatus statusCode) {
        throw new RuntimeException(String.format("Unrecognized status code %s when fetching customerId %s",
                statusCode, customerId));
    }
}
