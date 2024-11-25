package com.safetyreport.domain.api.dto.request;

import com.safetyreport.domain.api.dto.response.PhotoDetail;
import com.safetyreport.domain.service.domain.Photo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PostReportRequest(
        @NotNull(message = "사진은 필수 입력 값입니다")
        List<PhotoDetail> photoList,
        @NotNull(message = "내용은 필수 입력 값입니다")
        String content,
        @NotNull(message = "주소는 필수 입력 값입니다")
        String address,
        @NotNull(message = "전화번호는 필수 입력 값입니다")
        String phoneNumber,
        @NotNull(message = "카테고리는 필수 입력값입니다")
        String category
) {
}
