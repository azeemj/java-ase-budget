package com.ase.budgetase.service;

import com.ase.budgetase.entity.Transaction;
import com.ase.budgetase.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ase.budgetase.entity.Budget;
import com.ase.budgetase.repo.BudgetRepository;
import com.ase.budgetase.repo.TransactionRepository;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository trans_repo;

	public Transaction saveTrans(Transaction obj) {

		return trans_repo.save(obj);

	}

	public List<Transaction> getAllTransactions() {

		return trans_repo.findAll();
	}

	public List<Transaction> getAllTransactionsByCategories(int catid, int year, int month) {

		return trans_repo.findAllTransactionsByCategories(catid, year, month);
	}

	public List<Transaction> getTransactionsByMonthYear(int year, int month) {
		System.out.print("year" + year);
		return Collections.emptyList();
	}

}
