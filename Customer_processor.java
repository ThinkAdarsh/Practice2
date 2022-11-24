package com.BATCH.Spring_batch.CONFIG;

import com.BATCH.Spring_batch.ENTITY.Customer;
import org.springframework.batch.item.ItemProcessor;

public class Customer_processor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {
        if (customer.getLocation().equals("bbsr")) {
            return customer;
        }else {
            return null;
        }
    }
}
