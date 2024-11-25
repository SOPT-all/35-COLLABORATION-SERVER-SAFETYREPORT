package com.safetyreport.domain.service;

import com.safetyreport.domain.api.dto.response.BannerDetail;

import com.safetyreport.domain.api.dto.response.HomeRetrieveResponse;
import com.safetyreport.domain.api.dto.response.PhotoDetail;
import com.safetyreport.domain.entity.BannerEntity;
import com.safetyreport.domain.entity.PhotoEntity;
import com.safetyreport.domain.entity.UserEntity;
import com.safetyreport.domain.mapper.BannerMapper;
import com.safetyreport.domain.mapper.UserMapper;
import com.safetyreport.domain.repository.BannerRepository;
import com.safetyreport.domain.repository.PhotoRepository;
import com.safetyreport.domain.repository.ReportRepository;
import com.safetyreport.domain.repository.UserRepository;
import com.safetyreport.domain.service.domain.Banner;
import com.safetyreport.domain.service.domain.User;
import com.safetyreport.global.exception.BusinessException;
import com.safetyreport.global.exception.code.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {
    private final ReportRepository reportRepository;
    private final BannerRepository bannerRepository;
    private final UserRepository userRepository;
    private final PhotoRepository photoRepository;


    public List<BannerDetail> getBanners(){
        List<BannerEntity> bannerEntities = bannerRepository.findAll();
        if(bannerEntities.isEmpty()){
            throw new BusinessException(ErrorCode.DATA_NOT_FOUND);
        }

        List<BannerDetail> bannerDetails = bannerEntities.stream()
                .map(bannerEntity -> new BannerDetail(
                        bannerEntity.getId(), bannerEntity.getBannerUrl()
                ))
                .toList();
        return bannerDetails;
    }

    public User getUser(final Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        User user = UserMapper.toDomain(userEntity);
        return user;
    }
}