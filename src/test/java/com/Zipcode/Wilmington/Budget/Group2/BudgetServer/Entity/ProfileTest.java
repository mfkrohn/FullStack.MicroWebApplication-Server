package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;

public class ProfileTest {
    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(Profile.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Profile profile = new Profile();
        String json = jsonWriter.writeValueAsString(profile);
    }

}