package com.ase.budgetase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ase.budgetase.entity.Budget;
import com.ase.budgetase.entity.Category;
import com.ase.budgetase.service.BudgetService;
import com.ase.budgetase.service.UtilService;;



@RestController
@CrossOrigin(origins = "*")
public class BudgetController {
	
	@Autowired
	private BudgetService budget_service;
	
	@PostMapping("/budget")
	public ResponseEntity<Object> addBudget(@RequestBody Budget budgetObj) {
		 
		
		try {
			Budget ouputBudget= budget_service.saveBudget(budgetObj);
		
			return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, ouputBudget);
		} catch (Exception e) {
            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }	 
	}
	
	
	// delete budget
		 @DeleteMapping("/budget/{id}")
		    public ResponseEntity<Object> deleteBudget(@PathVariable int id) {
			 try {
				 boolean output = budget_service.deleteBudgetId(id);
				 return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, output);
			 } catch (Exception e) {
		            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		        }	   
		    }
		
		
		//update category
		@PutMapping("/budget")
	    public ResponseEntity<Object> updateBudget(@RequestBody Budget CategoryObj) {
			try {
				Budget output = budget_service.updateCategory(CategoryObj);
		        return UtilService.generateResponse("Successfully updated data!", HttpStatus.OK, output);
			} catch (Exception e) {
	            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
	        }	
	    }
	
	

}
