package com.safetyreport.domain.mapper;

import com.safetyreport.domain.entity.BannerEntity;
import com.safetyreport.domain.service.domain.Banner;

public class BannerMapper {
	public static Banner toDomain(BannerEntity entity) {
		return new Banner(entity.getId(), entity.getBannerUrl());
	}

	public static BannerEntity toEntity(Banner domain) {
		return BannerEntity.builder()
			.id(domain.getId())
			.bannerUrl(domain.getBannerUrl())
			.build();
	}
}
