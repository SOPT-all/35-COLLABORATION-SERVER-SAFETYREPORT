package com.safetyreport.domain.api.dto.response;

public record CategoryDetail(
	long categoryId,
	String categoryName,
	String categoryDescription
) {
}
