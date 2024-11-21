package com.safetyreport.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "banner")
public class BannerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "banner_url", nullable = false)
    private String bannerUrl;

    @Builder
    public BannerEntity(String bannerUrl, Long id) {
        this.bannerUrl = bannerUrl;
        this.id = id;
    }
}
