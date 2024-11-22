package com.safetyreport.domain.api.dto.response;

import java.time.LocalDateTime;

public record PhotoDetail(
	long photoId,
	String photoUrl,
	LocalDateTime createdAt
) {
}
