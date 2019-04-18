package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Data
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull
    private Integer profile_id;

    @NotNull
    private Double balance;

    public Account() {
    }

    public Account(@NotNull Integer profileID, @NotNull Double balance) {
        this.profile_id = profileID;
        this.balance = balance;
    }
}
