package com.safetyreport.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetyreport.domain.entity.ReportEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    Optional<ReportEntity> findByUserEntityId(final Long userId);
}
