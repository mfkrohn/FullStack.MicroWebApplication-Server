package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.Account;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.User;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {


    UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User create(@RequestBody User user){
        return userRepo.save(user);
    }

    public User getAccount(Integer userID){

        return null;
    }

    public User updateName(User user, Integer id){

        return user;
    }

    public Boolean deleteUser(Integer userID){

        return null;
    }
}
