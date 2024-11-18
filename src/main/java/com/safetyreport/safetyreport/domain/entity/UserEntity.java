package com.safetyreport.safetyreport.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "year_report_count")
    public int yearReportCount;

    @Column(name = "month_report_count")
    public int monthReportCount;

    @Column
    public int mileage;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ReportEntity> ReportEntities;

    @Builder
    public UserEntity(Long id, int mileage, int monthReportCount, int yearReportCount) {
        this.id = id;
        this.mileage = mileage;
        this.monthReportCount = monthReportCount;
        this.yearReportCount = yearReportCount;
    }
}
