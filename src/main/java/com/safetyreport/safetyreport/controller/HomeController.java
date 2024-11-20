package com.safetyreport.safetyreport.controller;

import com.safetyreport.safetyreport.dto.HomeResponse;
import com.safetyreport.safetyreport.dto.ResponseDto;
import com.safetyreport.safetyreport.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @GetMapping("/v1")
    ResponseEntity<?> getHome(@RequestHeader("user_Id") Long userId){;
        HomeResponse homeResponse = homeService.getHome(userId);
        ResponseDto<HomeResponse> response = new ResponseDto<>(
                "200",
                "성공",
                homeResponse
        );
        return ResponseEntity.ok(response);
    }



}
