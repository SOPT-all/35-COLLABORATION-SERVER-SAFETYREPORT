package com.safetyreport.safetyreport.repository;

import com.safetyreport.safetyreport.domain.entity.BannerEntity;
import org.springframework.boot.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BannerRepository extends JpaRepository<BannerEntity, Long> {
    Optional<BannerEntity> findByUserId(final Long userId);
}
