package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.BudgetServerApplication;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Controller.AccountController;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BudgetServerApplication.class)
public class AccountServiceTest {

    @MockBean
    private AccountService service;

    private AccountController controller;

    @Before
    public void setUp() {
        this.controller = new AccountController(service);
    }

    @Test
    public void testCreate(){
        HttpStatus expected = HttpStatus.CREATED;
        Account expectedAccount = new Account();
        BDDMockito
                .given(service.create(expectedAccount))
                .willReturn(expectedAccount);

        //When
        ResponseEntity<Account> response = controller.create(expectedAccount);
        HttpStatus actual = response.getStatusCode();
        Account actualAccount = response.getBody();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedAccount, actualAccount);
    }

    @Test
    public void testGetAccount() {
        HttpStatus expected = HttpStatus.OK;
        Account expectedAccount = new Account(1, 5.0);
        BDDMockito
                .given(service.getAccount(1))
                .willReturn(expectedAccount);

        // When
        ResponseEntity<Account> response = controller.read(1);
        HttpStatus actual = response.getStatusCode();
        Account actualAccount = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedAccount, actualAccount);
    }

    @Test
    public void testUpdate() {
        HttpStatus expected = HttpStatus.OK;
        Account newAccount = new Account(1, 5.0);
        BDDMockito
                .given(service.update(1, newAccount))
                .willReturn(newAccount);

        //When
        ResponseEntity<Account> response = controller.update(1, newAccount);
        HttpStatus actual = response.getStatusCode();
        Account actualAccount = response.getBody();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(newAccount, actualAccount);
    }

    @Test
    public void testWithdraw() {
        HttpStatus expected = HttpStatus.OK;
        Account withdrawnAccount = new Account(1, 5.0);
        BDDMockito
                .given(service.withdraw(1, 5.0))
                .willReturn(withdrawnAccount);

        //When
        ResponseEntity<Account> response = controller.withdraw(1, 5.0);
        HttpStatus actual = response.getStatusCode();
        Account actualAccount = response.getBody();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(withdrawnAccount, actualAccount);
    }

    @Test
    public void testDeposit() {
        HttpStatus expected = HttpStatus.OK;
        Account depositAccount = new Account(1, 10.0);
        BDDMockito
                .given(service.withdraw(1, 5.0))
                .willReturn(depositAccount);
        //When
        ResponseEntity<Account> response = controller.deposit(1, 5.0);
        HttpStatus actual = response.getStatusCode();
        Account actualAccount = response.getBody();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(depositAccount, actualAccount);
    }

    @Test
    public void testTransfer() {
        HttpStatus expected = HttpStatus.OK;
        Account account1 = new Account(1, 10.0);
        Account account2 = new Account(2, 10.0);
        Account[] accounts = {account1, account2};
        BDDMockito
                .given(service.transfer(1, 2, 5.0))
                .willReturn(accounts);

        //When
        ResponseEntity<Account[]> response = controller.transfer(1, 2, 5.0);
        HttpStatus actual = response.getStatusCode();
        Account[] actualAccounts = response.getBody();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(accounts, actualAccounts);
    }

    @Test
    public void testDelete() {
        HttpStatus expected = HttpStatus.OK;
        BDDMockito
                .given(service.delete(1))
                .willReturn(true);

        ResponseEntity<Boolean> response = controller.delete(1);
        HttpStatus actual = response.getStatusCode();
        Boolean actualBool = response.getBody();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(true, actualBool);
    }
}