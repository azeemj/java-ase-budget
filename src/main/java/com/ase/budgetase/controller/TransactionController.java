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
			Transaction ouput= trans_service.saveTrans(obj);

			return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, ouput);
		} catch (Exception e) {
            return UtilService.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
	}

	@GetMapping("/transaction-by-categories")
	public ResponseEntity<Object> getTransActionsByCategories() {


		try {

			HashMap<String, Object> map_outputs = new HashMap<String,Object>();



			//list all catgories
			 List<Category> CatouputList = cat_service.getAllCategories();


			//get all transaction by cat id monthly and yearly
			// List<Tarnsaction> TransOuput = trans_service.getAllTransactionsByCategories();

			 Iterator<Category> listIterator = CatouputList.iterator();
			    while(listIterator.hasNext()) {
			        Category category = listIterator.next();
			        System.out.print(  "-Cat id  "+category.getId() +"Name"+category.getName());

			        map_outputs.put("id", category.getId());
			        map_outputs.put("name", category.getName());

			        List<Transaction> TransOuput = trans_service.getAllTransactionsByCategories(category.getId());

			        System.out.print(  ",TransOuput "+TransOuput);

			        
			    	//HashMap<String, Object> map_output = new HashMap<String, Object>();
			        HashMap<String, Object> map_output = new HashMap<String, Object>();


			        Iterator<Transaction> listIteratorTra = TransOuput.iterator();
			        while(listIteratorTra.hasNext()) {



			        	Transaction transList= listIteratorTra.next();

			        	 map_output.put("id",  transList.getId());
			        	 map_output.put("amount",  transList.getAmount());
			        	 map_output.put("isRecurring",  transList.getIsrecurring());
			        	 map_output.put("datetime",  transList.getdatetime());

			        	//ArrayList asArrayList =new Array();

			        }

			        String myJsonObj2 = "{name:'Website'}";
			        // JSONObject jsonObject = new JSONObject();
			        

			        map_outputs.put("transaction",map_output);
			        //get allbudget
			        List BudgetOuput = budget_service.findAllBudgetsByCategories(category.getId());
			        Iterator<Budget> listIteratorBudegtIterator = BudgetOuput.iterator();
//			        while(listIteratorBudegtIterator.hasNext()) {
//			        	// Tarnsaction transList= listIteratorTra.next();
//
//			        	// map_outputs.put("budget",  listIteratorBudegtIterator.next());
//
//			        }
			    }



			return UtilService.generateResponse("Successfully added data!", HttpStatus.OK, map_outputs);
		} catch (Exception e) {
			System.out.print(  "-e.getMessage()  "+e.getMessage());
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
