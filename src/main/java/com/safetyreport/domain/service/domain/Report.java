package com.safetyreport.domain.service.domain;

import java.time.LocalDateTime;

import com.safetyreport.domain.entity.enums.CategoryEnum;

public class Report {
	private final long id;
	private final String content;
	private final String address;
	private final String phoneNumber;
	private final CategoryEnum categoryEnum;
	private final LocalDateTime createdAt;
	private final User user;
	private final Photo photo;

	public Report(long id, String content, String address, String phoneNumber, CategoryEnum categoryEnum, LocalDateTime createdAt, User user, Photo photo) {
		this.id = id;
		this.content = content;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.categoryEnum = categoryEnum;
		this.createdAt = createdAt;
		this.user = user;
		this.photo = photo;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public CategoryEnum getCategoryEnum() {
		return categoryEnum;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public User getUser() {
		return user;
	}

	public Photo getPhoto() {
		return photo;
	}
}