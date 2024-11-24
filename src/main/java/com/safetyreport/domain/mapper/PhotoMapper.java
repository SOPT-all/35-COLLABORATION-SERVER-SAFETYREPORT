package com.safetyreport.domain.mapper;

import com.safetyreport.domain.entity.PhotoEntity;
import com.safetyreport.domain.service.domain.Photo;

public class PhotoMapper {
	public static Photo toDomain(PhotoEntity entity) {
		return new Photo(
			entity.getId(),
			entity.getPhotoUrl(),
			entity.getCreatedAt(),
			UserMapper.toDomain(entity.getUserEntity())
		);
	}

	public static PhotoEntity toEntity(Photo domain) {
		return PhotoEntity.builder()
			.id(domain.getId())
			.photoUrl(domain.getPhotoUrl())
			.createdAt(domain.getCreatedAt())
			.userEntity(UserMapper.toEntity(domain.getUser()))
			.build();
	}
}
