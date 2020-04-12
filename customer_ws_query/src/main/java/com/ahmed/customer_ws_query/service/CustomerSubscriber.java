package com.ahmed.customer_ws_query.service;

import com.ahmed.common.customers.CustomerCreatedEvent;
import com.ahmed.common.customers.CustomerDeletedEvent;
import com.ahmed.common.customers.CustomerInfo;
import com.ahmed.common.customers.CustomerUpdatedEvent;
import com.ahmed.customer_ws_query.data.CustomerEntity;
import com.ahmed.customer_ws_query.service.CustomerService;
import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import org.springframework.beans.factory.annotation.Autowired;

@EventSubscriber(id = "com.ahmed.customer_ws.aggregate.Customer")
public class CustomerSubscriber {

    CustomerService service;

    @Autowired
    public CustomerSubscriber(CustomerService service) {
        this.service = service;
    }

    @EventHandlerMethod
    public void createCustomer(DispatchedEvent<CustomerCreatedEvent> event){
        CustomerInfo info = event.getEvent().getInfo();
        CustomerEntity entity = new CustomerEntity(event.getEntityId(),info.getFirstName(),info.getLastName(),info.getEmail());
        this.service.createCustomer(entity);
    }
    @EventHandlerMethod
    public void updateCustomer(DispatchedEvent<CustomerUpdatedEvent> event){
        CustomerInfo info = event.getEvent().getInfo();
        this.service.updateCustomer(event.getEntityId(),info);
    }
    @EventHandlerMethod
    public void deleteCustomer(DispatchedEvent<CustomerDeletedEvent> event){
        this.service.deleteCustomer(event.getEntityId());
    }

}
