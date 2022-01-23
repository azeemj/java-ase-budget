package com.ase.budgetase.controller;

import com.ase.budgetase.entity.Budget;
import com.ase.budgetase.entity.Category;
import com.ase.budgetase.entity.Transaction;
import com.ase.budgetase.service.BudgetService;
import com.ase.budgetase.service.CategoryService;
import com.ase.budgetase.service.TransactionService;
import com.ase.budgetase.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TransactionController {

	@Autowired
	private TransactionService trans_service;

	@Autowired
	private CategoryService cat_service;

	@Autowired
	private BudgetService budget_service;

	@PostMapping("/transaction")
	public ResponseEntity<Object> addTransAction(@RequestBody Transaction obj) {

		try {
			Transaction ouput = trans_service.saveTrans(obj);

			return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, ouput);
		} catch (Exception e) {
			return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@GetMapping("/transaction-by-categories/{datetime}")
	public ResponseEntity<Object> getTransActionsByCategories(@PathVariable String datetime) {

		try {

			// get the year and covert it into integer
			String[] temp = datetime.split("\\-");


			//total amount category wise
			float transactionCategoryWsie = 0;


			ArrayList<Object> array_list_categories = new ArrayList<Object>();

			// list all catgories
			List<Category> CatouputList = cat_service.getAllCategories();

			Iterator<Category> listIterator = CatouputList.iterator();
			while (listIterator.hasNext()) {

				HashMap<String, Object> map_outputs = new HashMap<String, Object>();

				Category category = listIterator.next();

				map_outputs.put("id", category.getId());
				map_outputs.put("name", category.getName());
        map_outputs.put("icon", category.getIcon());

        List<Transaction> TransOuput = trans_service.getAllTransactionsByCategories(category.getId(),
						Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));

				System.out.print(",TransOuput " + TransOuput);

				ArrayList<Object> array_list_trans = new ArrayList<Object>();

				Iterator<Transaction> listIteratorTra = TransOuput.iterator();
				while (listIteratorTra.hasNext()) {

					HashMap<String, Object> map_output = new HashMap<String, Object>();

					Transaction transList = listIteratorTra.next();
					System.out.print("transList.getAmount() " + transList.getId());

					map_output.put("id", transList.getId());
					map_output.put("amount", transList.getAmount());
					map_output.put("isRecurring", transList.getIsrecurring());
					map_output.put("datetime", transList.getdatetime());
					map_output.put("description", transList.getDescription());

					array_list_trans.add(map_output);

					transactionCategoryWsie = transactionCategoryWsie + transList.getAmount() ;

				}

				map_outputs.put("transactions", array_list_trans);

				// get allbudget
				ArrayList<Object> array_list_budget = new ArrayList<Object>();


				List BudgetOuput = budget_service.findAllBudgetsByCategories(category.getId(),
						Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));



				Iterator<Budget> listIteratorBudegtIterator = BudgetOuput.iterator();

				while (listIteratorBudegtIterator.hasNext()) {


					HashMap<String, Object> map_budget = new HashMap<String, Object>();


					HashMap<String, Object> map_output = new HashMap<String, Object>();


					Budget budgetList = listIteratorBudegtIterator.next();

					map_budget.put("id", budgetList.getId());
					map_budget.put("amount", budgetList.getAmount());
					map_budget.put("datetime", budgetList.getdatetime());
					map_budget.put("catid", budgetList.getCatid());
					map_budget.put("isRecurring", budgetList.getIsrecurring());

					array_list_budget.add(map_budget);
				}


				map_outputs.put("budget", array_list_budget);
				map_outputs.put("totalAmount",transactionCategoryWsie);

        transactionCategoryWsie = 0;

				array_list_categories.add(map_outputs);
			}

			return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, array_list_categories);
		} catch (Exception e) {
			System.out.print("-e.getMessage()  " + e.getMessage());
			return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	//update category
	  @PutMapping("/transaction")
	  public ResponseEntity<Object> updateTransaction(@RequestBody Transaction transObj) {
	    try {
	      Transaction updateObj = trans_service.updateTransaction(transObj);
	      return UtilService.generateResponse("Successfully updated data!", HttpStatus.OK, updateObj);
	    } catch (Exception e) {
	      return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
	    }
	  }
	  
	// delete budget
		@DeleteMapping("/transaction/{id}")
		public ResponseEntity<Object> deleteTrans(@PathVariable int id) {
			try {
				boolean output = trans_service.deleteTransyById(id);
				return UtilService.generateResponse("Successfully deleted!", HttpStatus.OK, output);
			} catch (Exception e) {
				return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
			}
		}


}
