package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Controller;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.Profile;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Repositories.ProfileRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileRepo repo;

    @Test
    public void testShow() throws Exception {
        Integer givenId = 1;
        BDDMockito
                .given(repo.findById(givenId))
                .willReturn(Optional.of(new Profile(givenId, "Davis")));

        String expectedContent = "{\"id\":1,\"name\":\"Davis\"}";
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/users/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testCreate() throws Exception {
        Profile profile = new Profile(1, "Davis");
        BDDMockito
                .given(repo.save(profile))
                .willReturn(profile);

        String expectedContent = "{\"id\":1,\"name\":\"Davis\"}";
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/users/")
                .content(expectedContent)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    /*@Test
    public void testGetAccounts() throws Exception {
        Profile user = new Profile(1, "Davis");
        Account account = new Account(1, 5.0);
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        user.setAccounts(accountList);

        BDDMockito
                .given(repo.findById(1))
                .willReturn(Optional.(user.getAccounts().get(0)));
    }*/
    //I have not figure out the above code yet
}
