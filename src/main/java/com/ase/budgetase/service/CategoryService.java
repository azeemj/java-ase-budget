package com.ase.budgetase.service;

import com.ase.budgetase.entity.Category;
import com.ase.budgetase.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository cat_repo;
  private UtilService util_serivceService;


  public Category saveCategory(Category categoryObj) {

    Category output = cat_repo.save(categoryObj);

    return output;
  }

  public List<Category> getAllCategories() {

    return cat_repo.findAll();
  }

  public Category getCategoryById(int id) {

    return cat_repo.findById(id).orElse(null);
  }

  public Category getCategoryByName(String name) {

    return cat_repo.findByName(name);
  }

  public boolean deleteCategoryById(int id) {
    try {
      cat_repo.deleteById(id);
      return true;
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Exception" + e);
      return false;
    }
  }

  public Category updateCategory(Category catObj) {
    try {
      System.out.println("catobj" + catObj.getId());
      Category exisCategobject = cat_repo.findById(catObj.getId()).orElse(null);
      exisCategobject.setName(catObj.getName());
      exisCategobject.seIcon(catObj.getIcon());
      return cat_repo.save(exisCategobject);
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Exception" + e);
      return catObj;
    }
  }


}
