package com.ase.budgetase.repo;

import com.ase.budgetase.entity.Budget;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BudgetRepository extends JpaRepository<Budget, Integer> {

	@Query(value = "SELECT * FROM budget WHERE catid = ?1", nativeQuery = true)
	List<Budget> findAllBudgetsByCategories(int catid);

  


}
