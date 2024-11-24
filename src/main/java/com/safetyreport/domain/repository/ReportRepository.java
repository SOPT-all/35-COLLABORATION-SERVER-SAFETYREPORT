package com.safetyreport.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetyreport.domain.entity.ReportEntity;

import java.util.Optional;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    Optional<ReportEntity> findByUserEntityId(final Long userId);
}
