package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Repositories.AccountRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @MockBean
    private AccountRepo repo;


    @MockBean
    private AccountService service;

    @Before
    public void setup() {
        service = new AccountService(repo);
    }

    @Test
    public void testCreate() {

    }
}