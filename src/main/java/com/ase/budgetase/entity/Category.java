package com.ase.budgetase.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "CATEGORY")
public class Category extends BaseEntity {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String icon;
	
	
    public Category()
    {
        super();
    }
	
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
	
	public String getIcon() {
		// TODO Auto-generated method stub
		return this.icon;
	}
	public void seIcon(String icon) {
		// TODO Auto-generated method stub
		this.icon = icon;
		
	}
	
	

}
