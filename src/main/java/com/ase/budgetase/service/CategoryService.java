package com.ase.budgetase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ase.budgetase.entity.Category;
import com.ase.budgetase.repo.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cat_repo;
	private Object object;
	
	
	public Category saveCategory(Category categoryObj) {
		return cat_repo.save(categoryObj);
		
	}
	
	public List <Category> getAllCategories(){
		
		return cat_repo.findAll();
	}
	
	public Category getCategoryById(int id){
		
		return cat_repo.findById(id).orElse(null);
	}
	
	public Category getCategoryByName(String name){
		
		return cat_repo.findByName(name);
	}
	
	public String deleteCategoryById(int id) {
		
		cat_repo.deleteById(id);
		
		return "Deleted -"+id;
	}
	
	public Category updateCategory(Category catObj) {
		
		Category exisCategobject = cat_repo.findById(catObj.getId()).orElse(null);
		exisCategobject.setName(exisCategobject.getName());
		return cat_repo.save(exisCategobject);
	}
	
	
}
