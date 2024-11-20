package com.safetyreport.safetyreport.service;

import com.safetyreport.safetyreport.domain.entity.BannerEntity;
import com.safetyreport.safetyreport.domain.entity.ReportEntity;
import com.safetyreport.safetyreport.domain.entity.UserEntity;
import com.safetyreport.safetyreport.dto.BannerResponse;
import com.safetyreport.safetyreport.dto.HomeResponse;

import com.safetyreport.safetyreport.repository.BannerRepository;
import com.safetyreport.safetyreport.repository.ReportRepository;
import com.safetyreport.safetyreport.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HomeService {
    private final ReportRepository reportRepository;
    private final BannerRepository bannerRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public HomeResponse getHome(final Long userId){
        ReportEntity reportEntity = findById(userId);
        int mileage = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException())
                .getMileage();
        List<BannerResponse> bannerResponse = getBanner();
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException());
        return HomeResponse.builder()
                .userId(userId)
                .bannerList(bannerResponse)
                .mileage(mileage)
                .yearReportCount(userEntity.getYearReportCount())
                .monthReportCount(userEntity.getMonthReportCount())
                .build();
    }

    public ReportEntity findById(final Long userId){
        return reportRepository.findByUserId(userId).orElseThrow(()->new RuntimeException());
    }

    public List<BannerResponse> getBanner(){
        List<BannerEntity> bannerList = bannerRepository.findAll();
        return bannerList.stream()
                .map(bannerEntity -> new BannerResponse(bannerEntity.getId(), bannerEntity.getBannerUrl()))
                .toList();

    }



}
