package com.safetyreport.domain.api.dto.response;

import java.util.List;

public record PhotoRetrieveResponse(
	List<PhotoDetail> photoList
) {
	public static PhotoRetrieveResponse of(List<PhotoDetail> photoList) {
		return new PhotoRetrieveResponse(photoList);
	}
}
