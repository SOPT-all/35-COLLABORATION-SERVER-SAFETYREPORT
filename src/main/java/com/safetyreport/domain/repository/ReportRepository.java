package com.safetyreport.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetyreport.domain.entity.ReportEntity;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
}
