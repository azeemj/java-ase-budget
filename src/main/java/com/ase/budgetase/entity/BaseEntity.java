package com.ase.budgetase.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {
  @CreatedDate
  @Column(name = "created_at", nullable = true)
  protected LocalDateTime createdAt = LocalDateTime.now();

  @LastModifiedDate
  @Column(name = "updated_at", nullable = true)
  protected LocalDateTime updatedAt = LocalDateTime.now();
}
