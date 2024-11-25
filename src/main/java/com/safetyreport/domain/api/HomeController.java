package com.safetyreport.domain.api;

import com.safetyreport.domain.api.dto.response.BannerDetail;
import com.safetyreport.domain.api.dto.response.HomeRetrieveResponse;
import com.safetyreport.domain.service.domain.User;
import com.safetyreport.global.exception.code.SuccessCode;
import com.safetyreport.global.exception.dto.SuccessResponse;
import com.safetyreport.domain.service.HomeService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/home")
@RequiredArgsConstructor
public class HomeController {
	private final HomeService homeService;

	@GetMapping
	ResponseEntity<SuccessResponse<HomeRetrieveResponse>> getHome(@RequestHeader long userId) {
		;
		User user = homeService.getUser(userId);
		List<BannerDetail> bannerDetailList = homeService.getBanners();
		HomeRetrieveResponse homeRetrieveResponse = new HomeRetrieveResponse(
			user.getId(),
			user.getYearReportCount(),
			user.getMonthReportCount(),
			user.getMileage(),
			bannerDetailList
		);

		return ResponseEntity.ok(
			SuccessResponse.of(SuccessCode.SUCCESS_FETCH, homeRetrieveResponse)
		);
	}

}
