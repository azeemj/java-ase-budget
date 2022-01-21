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

import com.ase.budgetase.entity.Category;
import com.ase.budgetase.service.CategoryService;



@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService cat_service;
	
	@PostMapping("/category")
	public Category addCategory(@RequestBody Category catObjCategory) {
		return cat_service.saveCategory(catObjCategory);
	}
	
	// delete category
	 @DeleteMapping("/category/{id}")
	    public String deleteProduct(@PathVariable int id) {
	        return cat_service.deleteCategoryById(id);
	    }
	
	
	//update category
	@PutMapping("/category")
    public Category updateCategory(@RequestBody Category CategoryObj) {
        return cat_service.updateCategory(CategoryObj);
    }
	
	
	//find Category
	@GetMapping("/category/{id}")
	public Category findCategoryById(@PathVariable int id) {
		return cat_service.getCategoryById(id);
	}

	
	//list all category
	@GetMapping("/categories")
	public List<Category> findAllCatsCategories() {
        return cat_service.getAllCategories();
    }
	

}
