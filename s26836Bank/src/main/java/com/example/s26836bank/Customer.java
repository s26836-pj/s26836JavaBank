package com.example.s26836bank;

import java.util.List;

public class Customer {

    private int customerID;
    private double balance;


    public Customer(double balance) {
        this.balance = balance;

        customerID++;
    }


    public int getCustomerID() {
        return customerID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", balance=" + balance +
                '}';
    }
}
