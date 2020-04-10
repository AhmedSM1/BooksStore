package com.ahmed.customer_ws.command;

import com.ahmed.common.customers.CustomerInfo;

public class UpdateCustomerCommand implements CustomerCommand {
    private CustomerInfo info;

    public UpdateCustomerCommand(CustomerInfo info) {
        this.info = info;
    }

    public CustomerInfo getInfo() {
        return info;
    }
}
