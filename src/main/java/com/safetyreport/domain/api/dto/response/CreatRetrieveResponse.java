package com.safetyreport.domain.api.dto.response;

import java.util.List;

public record CreatRetrieveResponse(
        String reportId,
        List<PhotoDetail> photoList,
        String content,
        String address,
        String phoneNumber,
        String category
) {
}
