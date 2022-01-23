package com.ase.budgetase.service;

import com.ase.budgetase.entity.Budget;
import com.ase.budgetase.entity.Category;
import com.ase.budgetase.entity.Transaction;
import com.ase.budgetase.repo.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

	@Autowired
	private BudgetRepository budget_repo;



	public Budget saveBudget(Budget obj) {

		return budget_repo.save(obj);

	}

	public List <Budget> getAllBudget(){

		return budget_repo.findAll();
	}



	public boolean deleteBudgetId(int id) {


		try {
			budget_repo.deleteById(id);
			return true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception"+ e);
				return false;
			}
	}


	public Budget updateCategory(Budget Obj) {
		try {

		Budget exisObject = budget_repo.findById(Obj.getId()).orElse(null);
		exisObject.setAmount(Obj.getAmount());
		return budget_repo.save(exisObject);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception"+ e);
			return Obj;
		}
	}
	
//	
//	public List<Budget> getAllBudgetsByCategories(int catid) {
//		
//		return  (List<Budget>) budget_repo.findAllBudgetsByCategories(catid);
//	}

	public List<Budget> findAllBudgetsByCategories(int catid) {
		// TODO Auto-generated method stub
		return budget_repo.findAllBudgetsByCategories(catid);
	}

	

}
