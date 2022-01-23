package com.ase.budgetase.service;

import com.ase.budgetase.entity.Transaction;
import com.ase.budgetase.repo.TransactionRepository;

public class IncomeService extends AbstractTransactionService {
  public Transaction saveTrans(Transaction obj, TransactionRepository trans_repo) {
    try {
      return trans_repo.save(obj);

    } catch (Exception e) {
      // TODO: handle exception
      return obj;
    }
  }
}
