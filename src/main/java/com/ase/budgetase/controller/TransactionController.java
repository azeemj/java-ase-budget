package com.ase.budgetase.controller;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.ase.budgetase.entity.*;

import com.ase.budgetase.service.*;



@RestController
@CrossOrigin(origins = "*")
public class TransactionController {
	
	@Autowired
	private TransactionService trans_service;
	
	@Autowired
	private CategoryService cat_service;
	
	@PostMapping("/transaction")
	public ResponseEntity<Object> addTransAction(@RequestBody Tarnsaction obj) {
		 
		
		try {
			Tarnsaction ouput= trans_service.saveTrans(obj);
		
			return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, ouput);
		} catch (Exception e) {
            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }	
	}
	
	@PostMapping("/transaction-by-categories")
	public ResponseEntity<Object> getTransActionsByCategories() {
		 
		
		try {
			
			 ArrayList<Object> finalout = new ArrayList<Object>();
			 
			 
			//list all catgories
			 List<Category> CatouputList = cat_service.getAllCategories();
			 
			 
			//get all transaction by cat id monthly and yearly
			// List<Tarnsaction> TransOuput = trans_service.getAllTransactionsByCategories();
			 
			 Iterator<Category> listIterator = CatouputList.iterator();
			    while(listIterator.hasNext()) {
			        System.out.print(  ", "+listIterator.next().getName());
			        System.out.print(  ",Cat id  "+listIterator.next().getId());
			        
			        List<Tarnsaction> TransOuput = trans_service.getAllTransactionsByCategories(listIterator.next().getId());
			        
			        System.out.print(  ",TransOuput "+TransOuput);
			        Iterator<Tarnsaction> listIteratorTra = TransOuput.iterator();
			        while(listIteratorTra.hasNext()) {
			        	
			        	System.out.print(  ",Cat id  "+listIteratorTra.next().getId());
			        }
			    }
			    
			  
		
			return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, CatouputList);
		} catch (Exception e) {
            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }	
	}
	
	
	
	
	//get all budget against by cat id monthyl and yearly
	
	
	
	
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
*/
	
	//list all category
//	@GetMapping("/transactions")
//	public ResponseEntity<Object> findAllByMonthYear() {
//		try {
//			List <Tarnsaction> ouput= trans_service.getTransactionsByMonthYear(2011,3);
//		
//			return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, ouput);
//		} catch (Exception e) {
//            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
//        }	
//    }
	

}
