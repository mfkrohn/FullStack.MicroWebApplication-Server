package com.Zipcode.Wilmington.Budget.Group2.BudgetServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class BudgetServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetServerApplication.class, args);
	}

	@RequestMapping("/")
	String index(){return "index";}

}
