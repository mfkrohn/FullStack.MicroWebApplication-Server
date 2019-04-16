package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.service;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.User;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Repositories.UserRepo;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service.UserService;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testCreate() {
        // given
        Integer expectedId = 1;
        String expectedName = "Julian";

        UserRepo mockRepo = mock(UserRepo.class);
        User userToReturn = new User(expectedId, expectedName);

        // when
        when(mockRepo.save(userToReturn)).thenReturn(userToReturn);
        UserService service = new UserService(mockRepo);
        User actual = service.create(userToReturn);

        // then
        Assert.assertEquals(expectedName, actual.getName());
    }

    @Test
    public void testUpdateName() {
        // given
        Integer expectedId = 1;
        String expectedName = "Sam";
        User userToUpdate = new User(1, "jkldsjaklsdj");

        UserRepo mockRepo = mock(UserRepo.class);

        // when
        UserService service = new UserService(mockRepo);
        service.create(userToUpdate);
        service.updateName(userToUpdate, expectedId);

        // then
        verify(mockRepo).save(userToUpdate);
    }

    @Test
    public void testDeleteUser() {
        // given
        Integer expectedId = 1;
        User userToDelete = new User(expectedId, "kdjaksjd");

        UserRepo mockRepo = mock(UserRepo.class);
        // when
        UserService service = new UserService(mockRepo);
        service.create(userToDelete);

        // then
        Assert.assertTrue(service.deleteUser(expectedId));
    }
}


// @MvcTest
// @RunWith(SpringRunner.class)