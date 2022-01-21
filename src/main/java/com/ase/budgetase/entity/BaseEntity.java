package com.ase.budgetase.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.ase.budgetase.service.CustomResponse;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity extends CustomResponse {

	@CreatedDate
    @Column(name = "created_at", nullable = true, updatable = false)
	protected LocalDateTime createdAt;
	
	@LastModifiedDate
    @Column(name = "updated_at",nullable = true)
	protected LocalDateTime updatedAt;
	
}