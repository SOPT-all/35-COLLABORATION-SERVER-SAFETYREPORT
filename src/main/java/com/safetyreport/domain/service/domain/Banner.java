package com.safetyreport.domain.service.domain;

public class Banner {
	private final long id;
	private final String bannerUrl;

	public Banner(long id, String bannerUrl) {
		this.id = id;
		this.bannerUrl = bannerUrl;
	}

	public long getId() {
		return id;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}
}
