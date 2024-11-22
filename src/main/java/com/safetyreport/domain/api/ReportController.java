package com.safetyreport.domain.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetyreport.domain.api.dto.response.CategoryDetail;
import com.safetyreport.domain.api.dto.response.CategoryRetrieveResponse;
import com.safetyreport.domain.api.dto.response.PhotoDetail;
import com.safetyreport.domain.api.dto.response.PhotoRetrieveResponse;
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
		@RequestHeader final Long userId
	){
		List<Photo> photoList = reportService.getPhotoList(userId);

		List<PhotoDetail> photoDetailList = photoList.stream()
			.map(photo -> new PhotoDetail(photo.getId(), photo.getPhotoUrl(), photo.getCreatedAt()))
			.toList();

		return ResponseEntity.ok(
			SuccessResponse.of(SuccessCode.SUCCESS_FETCH, PhotoRetrieveResponse.of(photoDetailList)));
	}
}
