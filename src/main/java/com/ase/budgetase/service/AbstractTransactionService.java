package com.ase.budgetase.service;

import com.ase.budgetase.entity.Transaction;
import com.ase.budgetase.repo.TransactionRepository;

public abstract class AbstractTransactionService {
  public abstract Transaction saveTrans(Transaction obj, TransactionRepository trans_repo);
}
