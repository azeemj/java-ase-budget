package com.ase.budgetase.service;

public class UtilService extends CustomResponse {
	
	
	String getCustomResponses(CustomResponse obj) {
		
		return "{content:{"+obj+"},status:true }";
	}
}
