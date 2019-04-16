package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Controller;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.Account;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.User;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> show(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @GetMapping("users/{userId}/accounts")
    public  ResponseEntity<List<Account>> getAccounts(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getAccounts(userId),HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> update(@PathVariable Integer userId, @RequestBody User user){
        return new ResponseEntity<>(userService.updateName(user, userId), HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }
}
