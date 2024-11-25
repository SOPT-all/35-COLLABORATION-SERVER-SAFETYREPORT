package com.safetyreport.domain.api.dto.response;

import java.util.List;

public record CreateRetrieveResponse(
        long reportId,
        List<PhotoDetail> photoList,
        String content,
        String address,
        String phoneNumber,
        String category
) {
}
