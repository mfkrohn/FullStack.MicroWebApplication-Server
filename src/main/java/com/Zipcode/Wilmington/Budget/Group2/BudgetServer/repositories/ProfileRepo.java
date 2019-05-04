package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.repositories;

import com.Zipcode.Wilmington.Budget.Group2.BudgetServer.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<Profile,Integer> {

}
