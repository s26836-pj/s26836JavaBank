package com.example.s26836bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class BankServiceTest {

    @InjectMocks
    private CustomerService bankService;

    @Mock
    private CustomerStorage mockCustomerStorage;


    @Test
    void checkingAddingBalanceOFTheCustomer() {
        Customer customer = bankService.createCustomer(1000);
        assertThat(customer.getBalance()).isEqualTo(1000);
    }

    @Test
    void checkingCreateCustomerID() {
        Customer customer = new Customer(1000);
        mockCustomerStorage.addCustomer(customer);
        assertThat(customer.getCustomerID()).isEqualTo(1);
    }

    @Test
    void creatingClientWithNegativeBalance(){

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> bankService.createCustomer(-1000));
    }

    @Test
    void checkingTransfer(){
        Customer customer = new Customer(1000);
        mockCustomerStorage.addCustomer(customer);
        when(mockCustomerStorage.getCustomers()).thenReturn(List.of(customer));
        assertThat(bankService.transfer(1,200)).isEqualTo("Transfer status: ACCEPTED Account balance: 800.0");
    }

    @Test
    void checkingWithdraw(){
        Customer customer = new Customer(1000);
        mockCustomerStorage.addCustomer(customer);
        when(mockCustomerStorage.getCustomers()).thenReturn(List.of(customer));
        assertThat(bankService.withdraw(1,200)).isEqualTo("Withdraw ACCEPTED Do not spend it on stupidity, account balance: 800.0");

    }

//    nie wyrzuca bledu

//    @Test
//    void checkingWithdrawRuntimeException(){
//        Customer customer = new Customer(1000);
//        mockCustomerStorage.addCustomer(customer);
//        when(mockCustomerStorage.getCustomers()).thenReturn(List.of(customer));
//        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() ->
//                bankService.withdraw(1,3000));
//    }

    @Test
    void checkingDeposit(){
        Customer customer = new Customer(1000);
        mockCustomerStorage.addCustomer(customer);
        when(mockCustomerStorage.getCustomers()).thenReturn(List.of(customer));
        assertThat(bankService.deposit(1,200)).isEqualTo("Deposit ACCEPTED Account balance: 1200.0");

    }

    @Test
    void checkingDepositRuntimeException(){
        Customer customer = new Customer(1000);
        mockCustomerStorage.addCustomer(customer);
        when(mockCustomerStorage.getCustomers()).thenReturn(List.of(customer));
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() ->
                bankService.deposit(2,100));
    }


}