package com.ase.budgetase.service;

import com.ase.budgetase.entity.Transaction;
import com.ase.budgetase.repo.TransactionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecurringIncomeService extends IncomeService {

  private static boolean setRecurring(Transaction obj, TransactionRepository trans_repo) {

    try {
      System.out.println("setRecurring" + obj);
      System.out.println("obj.getIsrecurring" + obj.getIsrecurring());
      if (obj.getIsrecurring()) {

        // get the start date
        LocalDateTime startDate = obj.getStartdate();

        // get the year and covert it into integer
        int startYear = startDate.getYear();
        int startMonth = startDate.getMonthValue();

        // get end date
        LocalDateTime endDate = obj.getEnddate();
        int endYear = endDate.getYear();
        int endMonth = endDate.getMonthValue();

        // insert into databse
        for (int i = startYear; i <= endYear; i++) {
          int temMonth = 0;
          if (endYear > startYear) {
            int remaing = endYear - startYear;
            temMonth = (remaing * 12) + startMonth;
          }

          System.out.println(startMonth + "  temMonth  " + temMonth);
          List<Transaction> objList = new ArrayList<Transaction>();

          for (int j = startMonth; j < temMonth; j++) {
            obj.datetime(obj.getStartdate().plusMonths(j));

            Transaction obj2 = new Transaction();
            // obj2 = obj;
            obj.setDescription("recurring" + j);
            obj2 = obj;

            System.out.println(j + "  obj  " + obj.getdatetime());
            trans_repo.save(obj2);
            Thread.sleep(100);
            obj2.setCatid(23);

            objList.add(obj2);
            obj2 = null;
          }
          System.out.println("  objList  " + objList);

          Iterator<Transaction> listIterator = objList.iterator();
          while (listIterator.hasNext()) {

            System.out.println("  objList  " + listIterator.next().getdatetime());
          }
          trans_repo.saveAll(objList);
        }

        return true;
      }
      return true;
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Exception" + e);
      return false;
    }

  }

  public Transaction saveTrans(Transaction obj, TransactionRepository trans_repo) {
    // return trans_repo.save(obj);
    setRecurring(obj, trans_repo);
    return obj;
  }
}
