package com.ase.budgetase.service;

import com.ase.budgetase.entity.Tarnsaction;
import com.ase.budgetase.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ase.budgetase.entity.Budget;
import com.ase.budgetase.entity.Tarnsaction;
import com.ase.budgetase.repo.BudgetRepository;
import com.ase.budgetase.repo.TransactionRepository;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService  {

	@Autowired
	private TransactionRepository trans_repo;



	public Tarnsaction saveTrans(Tarnsaction obj) {

		return trans_repo.save(obj);

	}

	public List <Tarnsaction> getAllTransactions(){

		return trans_repo.findAll();
	}

	public List <Tarnsaction> getAllTransactionsByCategories(int catid){

		return trans_repo.findAllTransactionsByCategories(catid);
	}




	public List <Tarnsaction> getTransactionsByMonthYear(int year, int month){
		System.out.print("year"+year);
		return   Collections.emptyList();
	}



//	public Budget getCategoryById(int id){
//
//		return budget_repo.findById(id).orElse(null);
//	}
//
////	public Budget getCategoryByName(String name){
////
////		return budget_repo.findByName(name);
////	}
//
//	public String deleteCategoryById(int id) {
//
//		budget_repo.deleteById(id);
//
//		return "{content:{"+"Deleted -"+id+ "},status:true }";
//	}
//
//	public Budget updateCategory(Budget Obj) {
//		try {
//
//
//		System.out.println("catobj"+ Obj.getId());
//		Budget exisCategobject = budget_repo.findById(Obj.getId()).orElse(null);
//		exisCategobject.setAmount(Obj.amount());
//		return budget_repo.save(exisCategobject);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("Exception"+ e);
//			return Obj;
//		}
//	}
//

}
