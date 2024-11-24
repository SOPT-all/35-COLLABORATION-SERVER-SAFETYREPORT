package com.safetyreport.domain.api.dto.response;

import java.util.List;

public record CategoryRetrieveResponse(
	List<CategoryDetail> categoryDetailList
) {
	public static CategoryRetrieveResponse of(List<CategoryDetail> categoryDetailList) {
		return new CategoryRetrieveResponse(categoryDetailList);
	}
}
