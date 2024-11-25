package com.safetyreport.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetyreport.domain.entity.PhotoEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
	List<PhotoEntity> findAllByUserEntityId(Long userId);

	@Modifying
	@Query("UPDATE PhotoEntity p SET p.reportEntity.id = :reportId WHERE p.id IN :photoIds")
	void updateReportIdForPhotos(@Param("reportId") Long reportId, @Param("photoIds") List<Long> photoIds);
}
