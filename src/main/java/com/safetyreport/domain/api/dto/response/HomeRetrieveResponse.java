package com.safetyreport.domain.api.dto.response;

import java.util.List;

public record HomeRetrieveResponse(
	long userId,
	int yearReportCount,
	int monthReportCount,
	int mileage,
	List<BannerDetail> bannerList
) {
	public static HomeRetrieveResponse of(long userId, int yearReportCount, int monthReportCount, int mileage,
		List<BannerDetail> bannerList) {
		return new HomeRetrieveResponse(userId, yearReportCount, monthReportCount, mileage, bannerList);
	}
}


