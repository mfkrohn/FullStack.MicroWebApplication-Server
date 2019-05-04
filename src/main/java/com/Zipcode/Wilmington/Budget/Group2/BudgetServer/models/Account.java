package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull
    @Column(name = "profile_id")
    private Integer profileID;

    @NotNull
    private Double balance;

    @JsonIgnore
    @ElementCollection
    @Column(name = "balance_history")
    private List<Double> balanceHistory = new ArrayList<>();

    public Account() {
    }

    public Account(@NotNull Integer profileID, @NotNull Double balance) {
        this.profileID = profileID;
        this.balance = balance;
    }

    public void updateBalanceHistory(){
        this.balanceHistory.add(balance);
    }
}
