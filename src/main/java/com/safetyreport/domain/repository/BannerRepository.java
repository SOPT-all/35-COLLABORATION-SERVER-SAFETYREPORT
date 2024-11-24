package com.safetyreport.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.safetyreport.domain.entity.BannerEntity;

import java.util.List;
import java.util.Optional;

public interface BannerRepository extends JpaRepository<BannerEntity, Long> {
}
