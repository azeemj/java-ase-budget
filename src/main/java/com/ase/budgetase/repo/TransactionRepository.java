package com.ase.budgetase.repo;

import com.ase.budgetase.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
  @Query(value = "SELECT * FROM transaction e WHERE e.catid = ?1 and year(e.datetime) = ?2 and month(e.datetime) = ?3", nativeQuery = true)
  List<Transaction> findAllTransactionsByCategories(int catid, int year, int month);
}
