package com.ase.budgetase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ase.budgetase.entity.Budget;
import com.ase.budgetase.entity.Tarnsaction;
import com.ase.budgetase.service.BudgetService;
import com.ase.budgetase.service.TransactionService;
import com.ase.budgetase.service.UtilService;;



@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService trans_service;
	
	@PostMapping("/transaction")
	public ResponseEntity<Object> addTransAction(@RequestBody Tarnsaction obj) {
		 
		
		try {
			Tarnsaction ouput= trans_service.saveTrans(obj);
		
			return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, ouput);
		} catch (Exception e) {
            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }	
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
