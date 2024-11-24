package com.safetyreport.domain.api;

import com.safetyreport.domain.api.dto.response.HomeRetrieveResponse;
import com.safetyreport.global.exception.code.SuccessCode;
import com.safetyreport.global.exception.dto.SuccessResponse;
import com.safetyreport.domain.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @GetMapping("/home")
    ResponseEntity<SuccessResponse<HomeRetrieveResponse>> getHome(@RequestHeader long userId){;
        HomeRetrieveResponse homeRetrieveResponse = homeService.getHome(userId);

        return ResponseEntity.ok(
                SuccessResponse.of(SuccessCode.SUCCESS_FETCH, homeRetrieveResponse)
        );
    }

}
