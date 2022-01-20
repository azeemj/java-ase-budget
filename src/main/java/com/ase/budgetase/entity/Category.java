package com.ase.budgetase.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice.This;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CATEGORY")
public class Category {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		
	}
	
	

}
