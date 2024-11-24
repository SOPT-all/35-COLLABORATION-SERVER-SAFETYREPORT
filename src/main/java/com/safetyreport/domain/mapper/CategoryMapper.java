package com.safetyreport.domain.mapper;

import com.safetyreport.domain.entity.CategoryEntity;
import com.safetyreport.domain.service.domain.Category;

public class CategoryMapper {
	public static Category toDomain(CategoryEntity entity) {
		return new Category(entity.getId(), entity.getName(), entity.getDescription());
	}

	public static CategoryEntity toEntity(Category domain) {
		return new CategoryEntity(domain.getDescription(), domain.getId(), domain.getName());
	}
}
