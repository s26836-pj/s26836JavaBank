package com.example.s26836bank;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerStorage customerStorage;
    private int customerID;

    public CustomerService(CustomerStorage storage) {
        this.customerStorage = storage;
    }

    public String transfer(int customerID, double transfer) {

        List<Customer> customers = customerStorage.getCustomers();
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                if (customer.getBalance() >= transfer) {
                    customer.setBalance(customer.getBalance() - transfer);
                    return "Transfer status: " + TransferStatus.ACCEPTED + " Account balance: "
                            + customer.getBalance();
                }
                if (customer.getBalance() < transfer) {
                    return "Transfer " + TransferStatus.DECLINED + " Lack of money on the account. Your balance: "
                            + customer.getBalance();
                }
            }
        }
        throw new RuntimeException("Wrong data to make a transfer");

    }

    public String deposit(int customerID, double deposit) {
        List<Customer> customers = customerStorage.getCustomers();

        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                customer.setBalance(customer.getBalance() + deposit);
                return "Deposit " + TransferStatus.ACCEPTED + " Account balance: " + customer.getBalance();
            }
        }
        throw new RuntimeException("Wrong data for deposit");
    }

    public String withdraw(int customerID, double withdraw) {
        List<Customer> customers = customerStorage.getCustomers();
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                if (customer.getBalance() >= withdraw) {
                    customer.setBalance(customer.getBalance() - withdraw);
                    return "Withdraw " + TransferStatus.ACCEPTED + " Do not spend it on stupidity, account balance: "
                            + customer.getBalance();
                }
                if (customer.getBalance() < withdraw) {
                    return "Poor little thing, your withdraw is " + TransferStatus.DECLINED + " no money";
                }
            }
        }
        throw new RuntimeException("Wrong data for withdraw");
    }

    public Customer createCustomer(double balance) {

        if (balance < 0) {
            throw new RuntimeException("Cannot create with negative balance!");
        }
        Customer customer = new Customer(balance);
        customerStorage.addCustomer(customer);
        return customer;
    }

}

