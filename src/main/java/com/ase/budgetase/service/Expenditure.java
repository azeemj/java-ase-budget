package com.ase.budgetase.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ase.budgetase.entity.Transaction;
import com.ase.budgetase.repo.TransactionRepository;

public class Expenditure extends AbstractTransactionService  {
	
	@Autowired
	protected TransactionRepository trans_repo;
	
	public Transaction saveTrans(Transaction obj, TransactionRepository trans_repo) {
		
		try {
			
			return trans_repo.save(obj);
					
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Exception xyz" + e);
			return obj;
		}
				

	}

}
