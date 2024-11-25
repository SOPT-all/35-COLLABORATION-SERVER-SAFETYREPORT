package com.safetyreport.domain.mapper;

import com.safetyreport.domain.entity.ReportEntity;
import com.safetyreport.domain.service.domain.Report;

public class ReportMapper {
	public static Report toDomain(ReportEntity entity) {
		return new Report(
			entity.getId(),
			entity.getContent(),
			entity.getAddress(),
			entity.getPhoneNumber(),
			entity.getCategoryEnum(),
			entity.getCreatedAt(),
			UserMapper.toDomain(entity.getUserEntity())
		);
	}

	public static ReportEntity toEntity(Report domain) {
		return ReportEntity.builder()
			.id(domain.getId())
			.content(domain.getContent())
			.address(domain.getAddress())
			.phoneNumber(domain.getPhoneNumber())
			.categoryEnum(domain.getCategoryEnum())
			.userEntity(UserMapper.toEntity(domain.getUser()))
			.build();
	}
}
