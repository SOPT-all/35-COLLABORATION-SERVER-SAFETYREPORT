package com.safetyreport.domain.service.domain;

public class User {
	private final long id;
	private final int yearReportCount;
	private final int monthReportCount;
	private final int mileage;

	public User(long id, int yearReportCount, int monthReportCount, int mileage) {
		this.id = id;
		this.yearReportCount = yearReportCount;
		this.monthReportCount = monthReportCount;
		this.mileage = mileage;
	}

	public long getId() {
		return id;
	}

	public int getYearReportCount() {
		return yearReportCount;
	}

	public int getMonthReportCount() {
		return monthReportCount;
	}

	public int getMileage() {
		return mileage;
	}
}
