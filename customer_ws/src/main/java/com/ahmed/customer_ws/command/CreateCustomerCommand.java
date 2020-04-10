package com.ahmed.customer_ws.command;

import com.ahmed.common.customers.CustomerInfo;

public class CreateCustomerCommand implements CustomerCommand {
    CustomerInfo info;

    public CreateCustomerCommand(CustomerInfo info) {
        this.info = info;
    }

    public CustomerInfo getInfo() {
        return info;
    }
}
