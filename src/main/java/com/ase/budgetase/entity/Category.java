package com.ase.budgetase.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


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
