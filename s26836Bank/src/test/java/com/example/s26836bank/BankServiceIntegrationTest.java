package com.example.s26836bank;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BankServiceIntegrationTest {

    @Autowired
    private CustomerService bankService;
    private CustomerStorage mockCustomerStorage;


    @Test
    void checkingTransfer(){
        Customer customer = new Customer(1000);
        mockCustomerStorage.addCustomer(customer);
        when(mockCustomerStorage.getCustomers()).thenReturn(List.of(customer));

        String remainingBalance = bankService.transfer(1,200);
        assertThat(remainingBalance).isEqualTo("Transfer status: ACCEPTED Account balance: 800.0");
    }
}
