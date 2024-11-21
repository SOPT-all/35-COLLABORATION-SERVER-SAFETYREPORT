package com.safetyreport.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.safetyreport.domain.entity.BannerEntity;

public interface BannerRepository extends JpaRepository<BannerEntity, Long> {
}
