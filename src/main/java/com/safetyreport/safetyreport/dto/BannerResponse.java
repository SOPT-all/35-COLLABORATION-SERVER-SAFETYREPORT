package com.safetyreport.safetyreport.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerResponse {
    private Long bannerId;
    private String bannerUrl;

    public BannerResponse(Long bannerId, String bannerUrl) {
        this.bannerId = bannerId;
        this.bannerUrl = bannerUrl;
    }
}
