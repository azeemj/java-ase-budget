package com.ase.budgetase.entity;


import java.time.LocalDateTime;
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
	private LocalDateTime datetime;
	
	

	
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public LocalDateTime getdatetime() {
		// TODO Auto-generated method stub
		return this.datetime;
	}
	public void setYearMonth(LocalDateTime datetime) {
		// TODO Auto-generated method stub
		this.datetime = datetime;
		
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
