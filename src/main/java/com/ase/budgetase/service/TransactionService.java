package com.ase.budgetase.service;

import com.ase.budgetase.entity.Transaction;
import com.ase.budgetase.logic.TransactionsFactory;
import com.ase.budgetase.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.TransactionFactory;

import com.ase.budgetase.entity.Budget;
import com.ase.budgetase.repo.BudgetRepository;
import com.ase.budgetase.repo.TransactionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {

	@Autowired
	public TransactionRepository trans_repo;
	
	private TransactionsFactory tFactory;

	public Transaction saveTrans(Transaction obj) {

        //return trans_repo.save(obj);
    	AbstractTransactionService abs = tFactory.createTransaction(obj);
    	System.out.print("abs" + abs);
		return abs.saveTrans(obj, trans_repo);

	}

	public List<Transaction> getAllTransactions() {

		return trans_repo.findAll();
	}

	public List<Transaction> getAllTransactionsByCategories(int catid, int year, int month) {

		return trans_repo.findAllTransactionsByCategories(catid, year, month);
	}

	public List<Transaction> getTransactionsByMonthYear(int year, int month) {
		return Collections.emptyList();
	}
	
	public Transaction updateTransaction(Transaction Obj) {
		try {

		Transaction exisObject = trans_repo.findById(Obj.getId()).orElse(null);
		exisObject.setAmount(Obj.getAmount());
		exisObject.setDescription(Obj.getDescription());
		exisObject.setIsrecurring(Obj.getIsrecurring());
		exisObject.datetime(Obj.getdatetime());
			
		return trans_repo.save(exisObject);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception"+ e);
			return Obj;
		}
	}
	
	
	public boolean deleteTransyById(int id) {
		try {
			trans_repo.deleteById(id);
		return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception"+ e);
			return false;
		}
	}
	
	public static boolean setRecurring(Transaction obj, TransactionRepository trans_repo) {
		  
		try {System.out.println("setRecurring"+ obj);
		System.out.println("obj.getIsrecurring"+ obj.getIsrecurring());
		if(obj.getIsrecurring()) {
		
			// get the start date 
			LocalDateTime startDate = obj.getStartdate();
			
			// get the year and covert it into integer
			int startYear = startDate.getYear();
			int startMonth = startDate.getMonthValue();
			
			//get end date
			LocalDateTime endDate = obj.getEnddate();
			int endYear = endDate.getYear();
			int endMonth = endDate.getMonthValue();
			System.out.println("startYear"+ startYear);
			System.out.println("endYear"+ endYear);
			System.out.println("startMonth"+ startMonth);
			System.out.println("endMonth"+ endMonth);
			
			
			//insert into databse 
			for(int i=startYear;i<=endYear;i++) {
				int temMonth = 0;
				if(endYear>startYear) {
					int remaing = endYear - startYear;
					temMonth = (remaing * 12) + startMonth;
				}
				
				System.out.println(startMonth+ "  temMonth  "+ temMonth);
				List<Transaction> objList = new ArrayList<Transaction>();

				for(int j=startMonth;j<temMonth;j++) {
					obj.datetime(obj.getStartdate().plusMonths(j));
					Transaction obj2 = new Transaction();
					obj2 = obj;
					
					
					System.out.println(j+ "  obj  "+ obj.getdatetime());
					//Budget savedObj = trans_repo.save(obj);
					
					objList.add(obj2);
				}
				System.out.println("  objList  "+ objList);
				trans_repo.saveAll(objList);
			}{
				Transaction savedObj = trans_repo.save(obj);
			}
			
			
			return true;
		}
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception"+ e);
			return false;
		}
		
		
	  }

}
