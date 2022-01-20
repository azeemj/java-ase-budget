package com.ase.budgetase.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ase.budgetase.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByName(String name);
	
	
	
	

}
