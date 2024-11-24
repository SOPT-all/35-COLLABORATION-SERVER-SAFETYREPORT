package com.safetyreport.domain.api.dto.request;

import com.safetyreport.domain.api.dto.response.PhotoDetail;
import com.safetyreport.domain.service.domain.Photo;

import java.util.List;

public record PostReportRequest(
        List<PhotoDetail> photoList,
        String content,
        String address,
        String phoneNumber,
        String category
) {
}
