package com.example.s26836bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S26836BankApplication implements CommandLineRunner {


    private final CustomerStorage customerStorage;
    private final CustomerService bankService;

    public S26836BankApplication(CustomerStorage customerStorage, CustomerService bankService) {
        this.customerStorage = customerStorage;
        this.bankService = bankService;
    }

    public static void main(String[] args) {
        SpringApplication.run(S26836BankApplication.class, args);
    }


    public void exec() {

        Customer customer = new Customer(1000);
        bankService.createCustomer(1000);




        System.out.println(customerStorage.getCustomers());
        System.out.println(bankService.withdraw(1,1001));

//        System.out.println(customer.getBalance());
//        bankService.deposit(1, 1000);
//        System.out.println(customer.getBalance());
//
//        bankService.transfer(1, 1500);
//        System.out.println(customer.getBalance());
//
//
//        System.out.println(customerStorage.getCustomers());


    }

    @Override
    public void run(String... args) throws Exception {
        exec();
    }
}
