package com.ase.budgetase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ase.budgetase.entity.Budget;
import com.ase.budgetase.service.BudgetService;;



@RestController
public class BudgetController {
	
	@Autowired
	private BudgetService budget_service;
	
	@PostMapping("/budget")
	public Budget addBudget(@RequestBody Budget budgetObj) {
		return budget_service.saveBudget(budgetObj);
	}
	
	/*
	// delete category
	 @DeleteMapping("/delete/{id}")
	    public String deleteProduct(@PathVariable int id) {
	        return cat_service.deleteCategoryById(id);
	    }
	
	
	//update category
	@PutMapping("/update")
    public Category updateCategory(@RequestBody Category CategoryObj) {
        return cat_service.updateCategory(CategoryObj);
    }
	
	
	//find Category
	@GetMapping("/catgeory-by-id/{id}")
	public Category findCategoryById(@PathVariable int id) {
		return cat_service.getCategoryById(id);
	}

	
	//list all category
	
	public List<Category> findAllCatsCategories() {
        return cat_service.getAllCategories();
    }
	*/

}
