package com.safetyreport.domain.api;

import java.util.List;

import com.safetyreport.domain.api.dto.request.PostReportRequest;
import com.safetyreport.domain.api.dto.response.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.safetyreport.domain.service.ReportService;
import com.safetyreport.domain.service.domain.Category;
import com.safetyreport.domain.service.domain.Photo;
import com.safetyreport.global.exception.code.SuccessCode;
import com.safetyreport.global.exception.dto.SuccessResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {

	private final ReportService reportService;

	@GetMapping("/category")
	ResponseEntity<SuccessResponse<CategoryRetrieveResponse>> getCategoryList(){
		List<Category> categoryList = reportService.getCategoryList();

		List<CategoryDetail> categoryDetailList = categoryList.stream()
			.map(category -> new CategoryDetail(category.getId(), category.getName(), category.getDescription()))
			.toList();

		return ResponseEntity.ok(
			SuccessResponse.of(SuccessCode.SUCCESS_FETCH, CategoryRetrieveResponse.of(categoryDetailList)));
	}

	@GetMapping("/photo")
	ResponseEntity<SuccessResponse<PhotoRetrieveResponse>> getPhotoList(
		@RequestHeader final long userId
	) {
		List<Photo> photoList = reportService.getPhotoList(userId);

		List<PhotoDetail> photoDetailList = photoList.stream()
				.map(photo -> new PhotoDetail(photo.getId(), photo.getPhotoUrl(), photo.getCreatedAt()))
				.toList();

		return ResponseEntity.ok(
				SuccessResponse.of(SuccessCode.SUCCESS_CREATE, PhotoRetrieveResponse.of(photoDetailList)));
	}

	@PostMapping
	ResponseEntity<SuccessResponse<CreateRetrieveResponse>> createReport(
			@RequestHeader final long userId,
			@RequestBody @Valid PostReportRequest postReportRequest
	){
		CreateRetrieveResponse creatRetrieveResponse =reportService.createReport(userId, postReportRequest);
		return ResponseEntity.ok(
				SuccessResponse.of((SuccessCode.SUCCESS_FETCH), creatRetrieveResponse)
		);

	}
}
