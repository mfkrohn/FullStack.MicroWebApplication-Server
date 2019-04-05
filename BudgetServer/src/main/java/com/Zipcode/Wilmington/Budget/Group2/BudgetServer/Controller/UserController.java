package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Controller;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.User;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

   private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody User user){

        return null;
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> show(@PathVariable Integer userId, @RequestBody User user){

        return null;
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> update(@PathVariable Integer userId, @RequestBody User user){

        return null;
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer uderId, @RequestBody User user){

        return null;
    }
}
