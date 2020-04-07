package com.ahmed.customer_ws.domain;

import com.ahmed.customer_ws.domain.CustomerCommand;
import com.ahmed.customer_ws.model.CustomerInfo;

public class CreateCustomerCommand implements CustomerCommand {
    CustomerInfo info;

    public CreateCustomerCommand(CustomerInfo info) {
        this.info = info;
    }

    public CustomerInfo getInfo() {
        return info;
    }
}
