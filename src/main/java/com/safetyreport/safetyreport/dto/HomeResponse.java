package com.safetyreport.safetyreport.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HomeResponse {
    private Long userId;
    private int yearReportCount;
    private int monthReportCount;
    private int mileage;
    private List<BannerResponse> bannerList;

    @Builder
    public HomeResponse(List<BannerResponse> bannerList, int mileage, int monthReportCount, Long userId, int yearReportCount) {
        this.bannerList = bannerList;
        this.mileage = mileage;
        this.monthReportCount = monthReportCount;
        this.userId = userId;
        this.yearReportCount = yearReportCount;
    }
}
