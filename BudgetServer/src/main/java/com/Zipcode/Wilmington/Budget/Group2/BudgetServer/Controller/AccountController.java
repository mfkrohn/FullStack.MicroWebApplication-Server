package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Controller;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.Account;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/accounts/")
    public ResponseEntity<Account> create(@RequestBody Account account){

        return null;
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<Account> read(@PathVariable Integer accountId){

        return null;
    }

    @PutMapping("/accounts/{accountId}")
    public  ResponseEntity<Account> update(@PathVariable Integer accountId, @RequestBody Account account){

        return null;
    }

    @PutMapping("/accounts/withdraw/{accountId}/{amount}")
    public ResponseEntity<Account> withdraw(@PathVariable Integer accountId,@PathVariable Double amount,@RequestBody Account account){

        return null;
    }

    @PutMapping("/accounts/deposit/{accountId}/{amount}")
    public ResponseEntity<Account> deposit(@PathVariable Integer accountId,@PathVariable Double amount, @RequestBody Account account){

        return null;
    }

    @PutMapping("/accounts/transfer/{account1Id}/{account2Id}/{amount}")
    public ResponseEntity<Account[]> transfer(@PathVariable Integer account1Id, @PathVariable Integer account2Id, @PathVariable Double amount, @RequestBody Account account1, @RequestBody Account account2){

        return null;
    }

    @DeleteMapping("/accounts/{accountId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer accountId){

        return null;
    }
}
