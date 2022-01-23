package com.ase.budgetase.service;

import com.ase.budgetase.entity.Transaction;
import com.ase.budgetase.logic.CurrencyFactory;
import com.ase.budgetase.repo.TransactionRepository;

public abstract class AbstractTransactionService {

	private CurrencyFactory currency;
	
	public abstract Transaction saveTrans(Transaction obj, TransactionRepository trans_repo);


}
