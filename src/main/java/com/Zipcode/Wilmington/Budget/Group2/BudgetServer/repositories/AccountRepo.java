package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.repositories;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer> {
    Set<Account> findAllByProfileID(Integer profile_id);

    Integer countByProfileID(Integer profile_id);

}
