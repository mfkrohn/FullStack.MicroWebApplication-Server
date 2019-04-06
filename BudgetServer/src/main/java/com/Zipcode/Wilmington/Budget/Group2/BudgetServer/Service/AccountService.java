package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Service;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.Account;
import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Exceptions.NoSuchEntityException;
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

        return accountRepo.save(account);
    }

    public Account getAccount(Integer accountID) throws NoSuchEntityException {
        if(accountRepo.getOne(accountID)!=null) {
        return accountRepo.getOne(accountID);
        }
        else{
            throw new NoSuchEntityException("Account: " + accountID + "does not exist.");
        }
    }

    public Account update(Integer accountID,Account newAccountData) throws NoSuchEntityException {
        Account account = getAccount(accountID);
        account.setBalance(newAccountData.getBalance());
        account.setUserID(newAccountData.getUserID());

        return account;
    }

    public Account withdraw(Integer accountID, Double amount) throws NoSuchEntityException {
        Account account = getAccount(accountID);
        if(amount > 0 && amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
        }
        return account;
    }

    public Account deposit(Integer accountID, Double amount) throws NoSuchEntityException {
        Account account = getAccount(accountID);
        if(amount > 0){
            account.setBalance(account.getBalance() + amount);
        }
        return account;
    }

    public void transfer(Integer accountIdFrom, Integer accountIdTo, Double amount) throws NoSuchEntityException {
        if(amount > 0){
        withdraw(accountIdFrom,amount);
        deposit(accountIdTo,amount);
        }

    }

    public Boolean delete(Integer accountID){
        accountRepo.deleteAccountById(accountID);
        return true;
    }


}
