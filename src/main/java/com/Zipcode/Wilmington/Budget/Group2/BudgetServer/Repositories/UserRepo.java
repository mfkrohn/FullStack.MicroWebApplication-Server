package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Repositories;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
