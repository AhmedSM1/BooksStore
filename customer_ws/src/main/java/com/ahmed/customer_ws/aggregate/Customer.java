package com.ahmed.customer_ws.aggregate;

import com.ahmed.common.customers.CustomerCreatedEvent;
import com.ahmed.common.customers.CustomerDeletedEvent;
import com.ahmed.common.customers.CustomerUpdatedEvent;
import com.ahmed.customer_ws.command.CreateCustomerCommand;
import com.ahmed.customer_ws.command.CustomerCommand;
import com.ahmed.common.customers.CustomerInfo;
import com.ahmed.customer_ws.command.DeleteCustomerCommand;
import com.ahmed.customer_ws.command.UpdateCustomerCommand;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

import java.util.List;

//aggregate to create Customer class
public class Customer extends ReflectiveMutableCommandProcessingAggregate<Customer, CustomerCommand> {

    private CustomerInfo info;


    public List<Event> process(CreateCustomerCommand cmd) {
        return EventUtil.events(new CustomerCreatedEvent(cmd.getInfo()));
    }

    public void apply(CustomerCreatedEvent event) {
     this.info = event.getInfo();
    }
    public List<Event> process(UpdateCustomerCommand cmd) {
        return EventUtil.events(new CustomerUpdatedEvent(cmd.getInfo()));
    }

    public void apply(CustomerUpdatedEvent event) {
        this.info = event.getInfo();
    }
    public List<Event> process(DeleteCustomerCommand cmd) {
        return EventUtil.events(new CustomerDeletedEvent(cmd.getCustomerId()));
    }

    public void apply(CustomerDeletedEvent event) {
    }

    public CustomerInfo getInfo() {
        return info;
    }
}
