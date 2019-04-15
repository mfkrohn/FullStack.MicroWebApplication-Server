package com.Zipcode.Wilmington.Budget.Group2.BudgetServer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class BudgetServerApplication {


	public static void main(String[] args) {
		SpringApplication.run(BudgetServerApplication.class, args);
	}



}
