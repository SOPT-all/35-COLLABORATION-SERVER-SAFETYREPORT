package com.safetyreport.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import com.safetyreport.domain.api.dto.request.PostReportRequest;
import com.safetyreport.domain.api.dto.response.CreateRetrieveResponse;
import com.safetyreport.domain.api.dto.response.PhotoDetail;
import com.safetyreport.domain.entity.ReportEntity;
import com.safetyreport.domain.entity.UserEntity;
import com.safetyreport.domain.entity.enums.CategoryEnum;
import com.safetyreport.domain.repository.ReportRepository;
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
	private final ReportRepository reportRepository;

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

	@Transactional
	public CreateRetrieveResponse createReport(Long userId, PostReportRequest postReportRequest){
		UserEntity userEntity = userRepository.findById(userId)
				.orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

		ReportEntity reportEntity = ReportEntity.builder()
				.content(postReportRequest.content())
				.address(postReportRequest.address())
				.phoneNumber(postReportRequest.phoneNumber())
				.categoryEnum(CategoryEnum.valueOf(postReportRequest.category()))
				.userEntity(userEntity)
				.build();

		ReportEntity savedReportEntity = reportRepository.save(reportEntity);

		photoRepository.updateReportIdForPhotos(
				savedReportEntity.getId(),
				postReportRequest.photoList().stream()
						.map(PhotoDetail::photoId)
						.toList()
		);

		List<Long> photoIds = postReportRequest.photoList().stream()
				.map(PhotoDetail::photoId)
				.toList();
		List<PhotoDetail> photoDetailList = photoRepository.findAllById(photoIds).stream()
				.map(photoEntity -> new PhotoDetail(
						photoEntity.getId(),
						photoEntity.getPhotoUrl(),
						LocalDateTime.now()
				))
				.toList();


		return new CreateRetrieveResponse(
				savedReportEntity.getId().toString(),
				photoDetailList,
				savedReportEntity.getContent(),
				savedReportEntity.getAddress(),
				savedReportEntity.getPhoneNumber(),
				savedReportEntity.getCategoryEnum().toString()
		);

	}
}
