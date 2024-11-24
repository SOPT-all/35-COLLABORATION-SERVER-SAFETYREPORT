package com.safetyreport.domain.mapper;

import com.safetyreport.domain.entity.UserEntity;
import com.safetyreport.domain.service.domain.User;

public class UserMapper {
	public static User toDomain(UserEntity entity) {
		return new User(
			entity.getId(),
			entity.getYearReportCount(),
			entity.getMonthReportCount(),
			entity.getMileage()
		);
	}

	public static UserEntity toEntity(User domain) {
		return UserEntity.builder()
			.id(domain.getId())
			.yearReportCount(domain.getYearReportCount())
			.monthReportCount(domain.getMonthReportCount())
			.mileage(domain.getMileage())
			.build();
	}
}
