package com.safetyreport.safetyreport.repository;

import com.safetyreport.safetyreport.domain.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    Optional<ReportEntity> findByUserId(final Long userId);
}
