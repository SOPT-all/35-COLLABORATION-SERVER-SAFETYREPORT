package com.safetyreport.domain.entity;

import com.safetyreport.domain.entity.enums.CategoryEnum;
import com.safetyreport.global.entity.BaseTimeEntity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "report")
public class ReportEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private CategoryEnum categoryEnum = CategoryEnum.PARKING;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    @ManyToOne(targetEntity = PhotoEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PhotoEntity photoEntity;

    @Builder
    public ReportEntity(String address, CategoryEnum categoryEnum, String content, LocalDateTime createdAt, Long id, String phoneNumber, PhotoEntity photoEntity, UserEntity userEntity) {
        this.address = address;
        this.categoryEnum = categoryEnum;
        this.content = content;
        this.createdAt = createdAt;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.photoEntity = photoEntity;
        this.userEntity = userEntity;
    }
}
