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

import com.ase.budgetase.entity.Category;
import com.ase.budgetase.service.CategoryService;
import com.ase.budgetase.service.UtilService;


@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
	
	@Autowired
	private CategoryService cat_service;
	
	
	@PostMapping("/category")
	public ResponseEntity<Object> addCategory(@RequestBody Category catObjCategory) {
		try {
			Category ouputCategory= cat_service.saveCategory(catObjCategory);
		
			return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, ouputCategory);
		} catch (Exception e) {
            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }	     
	}
	
	// delete category
	 @DeleteMapping("/category/{id}")
	    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
		 try {
			 boolean delCategory = cat_service.deleteCategoryById(id);
			 return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, delCategory);
		 } catch (Exception e) {
	            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
	        }	   
	    }
	
	
	//update category
	@PutMapping("/category")
    public ResponseEntity<Object> updateCategory(@RequestBody Category CategoryObj) {
		try {
			Category updateCategory = cat_service.updateCategory(CategoryObj);
	        return UtilService.generateResponse("Successfully updated data!", HttpStatus.OK, updateCategory);
		} catch (Exception e) {
            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }	
    }
	
	
	//find Category
	@GetMapping("/category/{id}")
	public ResponseEntity<Object> findCategoryById(@PathVariable int id) {
		 
		try {
			Category findCategory = cat_service.getCategoryById(id);
	        return UtilService.generateResponse("Successfully found data!", HttpStatus.OK, findCategory);
		} catch (Exception e) {
            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }	
	}

	
	//list all category
	@GetMapping("/categories")
	public ResponseEntity<Object> findAllCatsCategories() {
         
        try {
        	List <Category> listCat = cat_service.getAllCategories();
	        return UtilService.generateResponse("Successfully found data!", HttpStatus.OK, listCat);
		} catch (Exception e) {
            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }	
    }
	

}
