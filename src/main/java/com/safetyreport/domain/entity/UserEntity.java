package com.safetyreport.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import com.safetyreport.global.entity.BaseTimeEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "year_report_count", nullable = false)
    private int yearReportCount;

    @Column(name = "month_report_count", nullable = false)
    private int monthReportCount;

    @Column(name = "mileage", nullable = false)
    private int mileage;

    @Builder
    public UserEntity(Long id, int mileage, int monthReportCount, int yearReportCount) {
        this.id = id;
        this.mileage = mileage;
        this.monthReportCount = monthReportCount;
        this.yearReportCount = yearReportCount;
    }
}
