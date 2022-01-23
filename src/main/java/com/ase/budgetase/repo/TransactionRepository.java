package com.ase.budgetase.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ase.budgetase.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	// List<Tarnsaction> getByYearAndMonth(int year, int month);

	//Budget findByName(String name);

	@Query(value = "SELECT * FROM tarnsaction WHERE catid = ?1", nativeQuery = true)
	List<Transaction> findAllTransactionsByCategories(int catid);



}
