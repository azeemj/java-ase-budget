package com.ase.budgetase.repo;

import com.ase.budgetase.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

  Category findByName(String name);


}
