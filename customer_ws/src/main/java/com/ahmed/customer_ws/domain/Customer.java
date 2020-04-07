package com.ahmed.customer_ws.domain;

import com.ahmed.common.customers.CustomerCreatedEvent;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

import java.util.List;

//aggregate to create Customer class
public class Customer extends ReflectiveMutableCommandProcessingAggregate<Customer,CustomerCommand> {
    private String firstName;
    private String lastName;
    private String email;


    public List<Event> process(CreateCustomerCommand cmd) {
        return EventUtil.events(new CustomerCreatedEvent(cmd.info.getFirstName(),cmd.info.getLastName(),cmd.info.getEmail()));
    }
    public void apply(CustomerCreatedEvent event) {
      this.firstName = event.getFirstName();
      this.lastName = event.getLastName();
      this.email = event.getEmail();
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
