package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.BudgetServerApplication;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Controller.ProfileController;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.Account;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BudgetServerApplication.class)
@TestPropertySource(locations="classpath:application.properties")
public class ProfileServiceTest {

    @MockBean
    private ProfileService service;

    private ProfileController controller;

    @Before
    public void setUp() {
        this.controller = new ProfileController(service);
    }

    @Test
    public void testCreate() {
        //Given
        HttpStatus expected = HttpStatus.CREATED;
        Profile expectedProfile = new Profile();
        BDDMockito
                .given(service.create(expectedProfile))
                .willReturn(expectedProfile);

        //When
        ResponseEntity<Profile> response = controller.create(expectedProfile);
        HttpStatus actual = response.getStatusCode();
        Profile actualProfile = response.getBody();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedProfile, actualProfile);
    }

    @Test
    public void testGetProfile() {
        //Given
        HttpStatus expected = HttpStatus.OK;
        Profile expectedProfile = new Profile(1, "Davis");
        BDDMockito
                .given(service.getUser(1))
                .willReturn(expectedProfile);

        // When
        ResponseEntity<Profile> response = controller.show(1);
        HttpStatus actual = response.getStatusCode();
        Profile actualProfile = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedProfile, actualProfile);
    }

    //Given
    @Test
    public void testDeleteProfile() {
        //Given
        HttpStatus expected = HttpStatus.OK;
        Profile expectedProfile = new Profile(1, "Davis");
        BDDMockito
                .given(service.deleteUser(1))
                .willReturn(true);

        //When
        ResponseEntity<Boolean> response = controller.delete(1);
        HttpStatus actual = response.getStatusCode();
        Boolean actualBoolean = response.getBody();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(true, actualBoolean);
    }

    @Test
    public void testGetAccounts() {
        //Given
        HttpStatus expected = HttpStatus.OK;
        Account account = new Account(1, 5.0);
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        BDDMockito
                .given(service.getAccounts(1))
                .willReturn(accountList);

        //When
        ResponseEntity<List<Account>> response = controller.getAccounts(1);
        HttpStatus actual = response.getStatusCode();
        List<Account> actualAccounts = response.getBody();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(accountList, actualAccounts);
    }
}