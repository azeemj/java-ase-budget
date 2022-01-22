package com.ase.budgetase.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "Tarnsaction")
public class Tarnsaction extends BaseEntity {
  @Id
  @GeneratedValue
  private int id;
  private float amount;
  private boolean isrecurring;
  private int catid;

  @Column(name = "datetime")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime datetime;


  public Integer getId() {
    // TODO Auto-generated method stub
    return this.id;
  }

  public LocalDateTime getdatetime() {
    // TODO Auto-generated method stub
    return this.datetime;
  }

  public void datetime(LocalDateTime datetime) {
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

  public float catid() {
    // TODO Auto-generated method stub
    return this.catid;
  }

  public void setCatid(int catid) {
    // TODO Auto-generated method stub
    this.catid = catid;

  }


}
