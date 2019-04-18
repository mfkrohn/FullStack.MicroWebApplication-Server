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

    @Column(name = "profile_id")
    @NotNull
    private Integer profileID;

    @NotNull
    private Double balance;

    public Account() {
    }

    public Account(@NotNull Integer profileID, @NotNull Double balance) {
        this.profileID = profileID;
        this.balance = balance;
    }
}
