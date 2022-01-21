package com.ase.budgetase.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ase.budgetase.entity.Budget;


public interface BudgetRepository extends JpaRepository<Budget, Integer> {

	//Budget findByName(String name);
	
	
	
	

}
