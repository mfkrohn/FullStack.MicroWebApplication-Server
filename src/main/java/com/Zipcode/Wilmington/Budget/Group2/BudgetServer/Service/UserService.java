package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.Account;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.User;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User create(User user){
        return userRepo.save(user);
    }

    public User getUser(Integer userID){
        return userRepo.findById(userID).get();
    }

    public List<Account> getAccounts(Integer userId){
        return userRepo.findById(userId).get().getAccounts();
    }

//    public User updateName(User user, Integer userID){
//        User originalUser = userRepo.findById(userID).get();
//        originalUser.setName(user.getName());
//        return userRepo.save(originalUser);
//    }

    public Boolean deleteUser(Integer userID){
        userRepo.deleteById(userID);
        return true;
    }
}
