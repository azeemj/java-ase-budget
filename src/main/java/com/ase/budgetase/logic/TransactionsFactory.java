package com.ase.budgetase.logic;

import com.ase.budgetase.entity.Transaction;
import com.ase.budgetase.service.*;

public class TransactionsFactory {
  public static AbstractTransactionService createTransaction(Transaction obj) {
    if (obj.getIsrecurring() == true && obj.getAmount() > 0) {
      AbstractTransactionService abs = new RecurringIncomeService();
      return abs;

    } else if (obj.getIsrecurring() == false && obj.getAmount() > 0) {
      AbstractTransactionService abs = new IncomeService();
      return abs;
    } else if (obj.getIsrecurring() == true && obj.getAmount() < 0) {
      AbstractTransactionService abs = new RecurringExpenditure();
      return abs;

    }

    AbstractTransactionService abs = new Expenditure();

    return abs;
  }
}
