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
@Table(name = "Transaction")
public class Transaction extends BaseEntity {
	@Id
	@GeneratedValue
	private int id;
	private float amount;
	private boolean isrecurring;
	private int catid;
	private String description;
	private int parentid;

	@Column(name = "datetime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime datetime;

	@Column(name = "startdate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startdate;

	@Column(name = "enddate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime enddate;

	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;

	}

	public LocalDateTime getdatetime() {
		// TODO Auto-generated method stub
		return this.datetime;
	}

	public void datetime(LocalDateTime datetime) {
		// TODO Auto-generated method stub
		this.datetime = datetime;

	}

	public float getAmount() {
		// TODO Auto-generated method stub
		return this.amount;
	}

	public void setAmount(Float amount) {
		// TODO Auto-generated method stub
		this.amount = amount;

	}

	public float getCatid() {
		// TODO Auto-generated method stub
		return this.catid;
	}

	public void setCatid(int catid) {
		// TODO Auto-generated method stub
		this.catid = catid;

	}

	public boolean getIsrecurring() {
		// TODO Auto-generated method stub
		return this.isrecurring;
	}

	public void setIsrecurring(Boolean isrecurring) {
		// TODO Auto-generated method stub
		this.isrecurring = isrecurring;

	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;

	}

	public LocalDateTime getEnddate() {
		// TODO Auto-generated method stub
		return this.enddate;
	}

	public void setEnddate(LocalDateTime enddate) {
		// TODO Auto-generated method stub
		this.enddate = enddate;

	}

	public int getparentid() {
		// TODO Auto-generated method stub
		return this.parentid;
	}

	public void setparentid(int parentid) {
		// TODO Auto-generated method stub
		this.parentid = parentid;

	}

	public LocalDateTime getStartdate() {
		// TODO Auto-generated method stub
		return this.startdate;
	}

	public void setStartdate(LocalDateTime startdate) {
		// TODO Auto-generated method stub
		this.startdate = startdate;

	}
}
