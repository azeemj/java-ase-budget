package com.ase.budgetase.service;

import com.ase.budgetase.entity.Budget;
import com.ase.budgetase.entity.Category;
import com.ase.budgetase.entity.Transaction;
import com.ase.budgetase.repo.BudgetRepository;

import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetService {

	@Autowired
	private BudgetRepository budget_repo;

	public Budget saveBudget(Budget obj) {

		setRecurring(obj, budget_repo);
		return obj;

	}

	public List<Budget> getAllBudget() {

		return budget_repo.findAll();
	}

	public boolean deleteBudgetId(int id) {

		try {
			budget_repo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception" + e);
			return false;
		}
	}

	public Budget updateBudget(Budget Obj) {
		try {

			Budget exisObject = budget_repo.findById(Obj.getId()).orElse(null);
			exisObject.setAmount(Obj.getAmount());
			exisObject.setCatid(Obj.getCatid());
			exisObject.setIsrecurring(Obj.getIsrecurring());
			return budget_repo.save(exisObject);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception" + e);
			return Obj;
		}
	}

//	
//	public List<Budget> getAllBudgetsByCategories(int catid) {
//		
//		return  (List<Budget>) budget_repo.findAllBudgetsByCategories(catid);
//	}

	public List<Budget> findAllBudgetsByCategories(int catid, int year, int month) {
		// TODO Auto-generated method stub
		return budget_repo.findAllBudgetsByCategories(catid, year, month);
	}

	public static Budget setRecurring(Budget obj, BudgetRepository budget_repo) {

		try {
			System.out.println("setRecurring" + obj);
			System.out.println("obj.getIsrecurring" + obj.getIsrecurring());
			if (obj.getIsrecurring()) {

				// get the start date
				LocalDateTime startDate = obj.getStartdate();

				// get the year and covert it into integer
				int startYear = startDate.getYear();
				int startMonth = startDate.getMonthValue();

				// get end date
				LocalDateTime endDate = obj.getEnddate();
				int endYear = endDate.getYear();
				int endMonth = endDate.getMonthValue();
				System.out.println("startYear" + startYear);
				System.out.println("endYear" + endYear);
				System.out.println("startMonth" + startMonth);
				System.out.println("endMonth" + endMonth);

				// insert into databse
				List<Budget> objList = new ArrayList<Budget>();
				Budget savedObj = null ;
				
				for (int i = startYear; i <= endYear; i++) {
					int temMonth = 0;
					if (endYear > startYear) {
						int remaing = endYear - startYear;
						temMonth = (remaing * 12) + startMonth;
					}

					System.out.println(startMonth + "  temMonth  " + temMonth);
					

					for (int j = startMonth; j < temMonth; j++) {
						obj.setDatetime(obj.getStartdate().plusMonths(j));
						Budget obj2 = null;
						obj2 = obj;

						System.out.println(j + "  obj  " + obj.getdatetime());
					    savedObj = budget_repo.save(obj);

						objList.add(obj2);
					}
					System.out.println("  objList  " + objList);
					
				}

				budget_repo.saveAll(objList);
				return savedObj;
			}
			

			return budget_repo.save(obj);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception" + e);
			return obj;
		}

	}

}
