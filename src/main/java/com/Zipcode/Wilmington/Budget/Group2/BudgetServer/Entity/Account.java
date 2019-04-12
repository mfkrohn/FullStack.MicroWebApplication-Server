package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Integer userID;

    @NotNull
    private Double balance;

    public Account() {
    }

    public Account(@NotNull Integer userID, @NotNull Double balance) {
        this.userID = userID;
        this.balance = balance;
    }

}
