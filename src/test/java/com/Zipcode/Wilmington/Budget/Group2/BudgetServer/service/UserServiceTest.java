package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.service;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.User;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Repositories.UserRepo;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service.UserService;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    public void testCreate() {
        // given
        Integer expectedId = 1;
        String expectedName = "Julian";
        User user = new User(expectedId, "kjskdjaskdjskl");

        UserRepo mockRepo = mock(UserRepo.class);

        User userToReturn = new User(expectedId, expectedName);
//        userToReturn.setName("Julian");

        // when
        when(mockRepo.save(user)).thenReturn(userToReturn);
        UserService service = new UserService(mockRepo);
        User actual = service.create(user);

        // then
        Assert.assertEquals(expectedName, actual.getName());
    }
}
