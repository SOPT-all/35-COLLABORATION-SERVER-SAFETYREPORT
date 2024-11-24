package com.safetyreport.domain.entity;


import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.safetyreport.global.entity.BaseTimeEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "photo")
public class PhotoEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    @ManyToOne(targetEntity = ReportEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ReportEntity reportEntity;


    @Builder
    public PhotoEntity(Long id, String photoUrl, ReportEntity reportEntity, UserEntity userEntity) {
        this.id = id;
        this.photoUrl = photoUrl;
        this.reportEntity = reportEntity;
        this.userEntity = userEntity;
    }
}
