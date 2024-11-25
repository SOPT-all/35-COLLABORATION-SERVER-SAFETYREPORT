package com.safetyreport.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetyreport.domain.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
