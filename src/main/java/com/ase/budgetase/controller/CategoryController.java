package com.ase.budgetase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ase.budgetase.entity.Category;
import com.ase.budgetase.service.CategoryService;



@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService cat_service;
	
	@PostMapping("/add-category")
	public Category addCategory(@RequestBody Category catObjCategory) {
		return cat_service.saveCategory(catObjCategory);
	}
	
	// delete category
	
	
	//update category
	
	
	
	

}
