package com.ase.budgetase.entity;


import java.time.YearMonth;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "Budget")
public class Budget extends BaseEntity {
	@Id
	@GeneratedValue
	private int id;
	private float amount;
	private String yearmonth;
	
	

	
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public String getYearMonth() {
		// TODO Auto-generated method stub
		return this.yearmonth;
	}
	public void setYearMonth(String yearmonth) {
		// TODO Auto-generated method stub
		this.yearmonth = yearmonth;
		
	}
	
	
	public float amount() {
		// TODO Auto-generated method stub
		return this.amount;
	}
	public void setAmount(Float amount) {
		// TODO Auto-generated method stub
		this.amount = amount;
		
	}
	
	
	

}
