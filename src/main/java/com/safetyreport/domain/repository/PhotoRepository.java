package com.safetyreport.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetyreport.domain.entity.PhotoEntity;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
	List<PhotoEntity> findAllByUserEntityId(Long userId);
}
