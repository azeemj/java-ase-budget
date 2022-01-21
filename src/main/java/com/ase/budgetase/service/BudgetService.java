package com.ase.budgetase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ase.budgetase.entity.Budget;
import com.ase.budgetase.repo.BudgetRepository;

import java.util.List;

@Service
public class BudgetService {

	@Autowired
	private BudgetRepository budget_repo;
	
	
	
	public Budget saveBudget(Budget obj) {
		
		return budget_repo.save(obj);
		
	}
	
	public List <Budget> getAllCategories(){
		
		return budget_repo.findAll();
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
