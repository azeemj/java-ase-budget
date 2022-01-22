package com.ase.budgetase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class BudgetaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetaseApplication.class, args);
	}
  
}
