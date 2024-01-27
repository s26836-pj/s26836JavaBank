package com.example.s26836bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerStorage {

    List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "CustomerStorage{" +
                "customers=" + customers +
                '}';
    }
}
