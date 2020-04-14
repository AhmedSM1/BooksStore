package com.ahmed.order_ws.service;

import com.ahmed.order_ws.model.CustomerResponseModel;

public interface CustomerServiceRestTemplete {
    CustomerResponseModel getCustomer(String customerId);
}
