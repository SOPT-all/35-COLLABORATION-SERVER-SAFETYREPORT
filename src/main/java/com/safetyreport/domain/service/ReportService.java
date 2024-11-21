package com.safetyreport.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safetyreport.domain.entity.CategoryEntity;
import com.safetyreport.domain.entity.PhotoEntity;
import com.safetyreport.domain.mapper.CategoryMapper;
import com.safetyreport.domain.mapper.PhotoMapper;
import com.safetyreport.domain.repository.CategoryRepository;
import com.safetyreport.domain.repository.PhotoRepository;
import com.safetyreport.domain.repository.UserRepository;
import com.safetyreport.domain.service.domain.Category;
import com.safetyreport.domain.service.domain.Photo;
import com.safetyreport.global.exception.BusinessException;
import com.safetyreport.global.exception.code.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {

	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;
	private final PhotoRepository photoRepository;

	@Transactional(readOnly = true)
	public List<Category> getCategoryList() {
		List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
		if (categoryEntityList.isEmpty()) {
			throw new BusinessException(ErrorCode.DATA_NOT_FOUND);
		}

		return categoryEntityList.stream()
			.map(CategoryMapper::toDomain)
			.toList();
	}

	@Transactional(readOnly = true)
	public List<Photo> getPhotoList(Long userId) {
		userRepository.findById(userId)
			.orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

		List<PhotoEntity> photoEntityList = photoRepository.findAllByUserEntityId(userId);
		if (photoEntityList.isEmpty()) {
			throw new BusinessException(ErrorCode.DATA_NOT_FOUND);
		}

		return photoEntityList.stream()
			.map(PhotoMapper::toDomain)
			.toList();
	}
}
