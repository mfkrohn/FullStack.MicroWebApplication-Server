package com.Zipcode.Wilmington.Budget.Group2.BudgetServer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Profile {

    @Id
    @Column(name = "profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "profileID", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Account> accounts = new HashSet<>(0);

    private Integer numberOfAccounts = getNumberOfAccounts();

    public Profile() {
    }

    public Profile(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Formula("(select count(*) from accounts where profile_id = profile_id)")
    public Integer getNumberOfAccounts(){
        return numberOfAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id) &&
                Objects.equals(name, profile.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}


