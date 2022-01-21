package com.ase.budgetase.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ase.budgetase.entity.Tarnsaction;

public interface TransactionRepository extends JpaRepository<Tarnsaction, Integer> {

	//Budget findByName(String name);
	
	
	
	

}
