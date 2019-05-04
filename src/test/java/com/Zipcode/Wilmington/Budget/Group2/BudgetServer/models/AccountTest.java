package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;

public class AccountTest {

    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(Account.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWritter = new ObjectMapper();
        Account account = new Account();
        String json = jsonWritter.writeValueAsString(account);
    }

}