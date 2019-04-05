package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.Account;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    AccountRepo accountRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account create(Account account){

        return account;
    }

    public Account getAccount(Integer accountID){

        return null;
    }

    public Account update(Integer accountID,Account account){

        return account;
    }

    public Account withdraw(Integer accountID, Double amount){

        return null;
    }

    public Account deposit(Integer accountID, Double amount){

        return null;
    }

    public void transfer(Integer accountIdFrom, Integer accountIdTo, Double amount){

    }

    public void delete(Integer accountID){

    }


}
