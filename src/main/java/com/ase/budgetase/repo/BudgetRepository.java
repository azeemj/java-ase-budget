package com.ase.budgetase.repo;

import com.ase.budgetase.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BudgetRepository extends JpaRepository<Budget, Integer> {

  //Budget findByName(String name);


}
