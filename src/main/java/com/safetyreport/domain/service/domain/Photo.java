package com.safetyreport.domain.service.domain;

import java.time.LocalDateTime;

public class Photo {
	private final long id;
	private final String photoUrl;
	private final LocalDateTime createdAt;
	private final User user;

	public Photo(long id, String photoUrl, LocalDateTime createdAt, User user) {
		this.id = id;
		this.photoUrl = photoUrl;
		this.createdAt = createdAt;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public User getUser() {
		return user;
	}
}
