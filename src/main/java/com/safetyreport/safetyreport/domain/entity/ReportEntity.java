package com.safetyreport.safetyreport.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String content;

    @Column
    public String address;

    @Column(name = "phone_number")
    public String phoneNumber;

    @Enumerated(EnumType.STRING)
    public String category;

    @Column(name = "created_at")
    public LocalDateTime createdAt;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @Builder
    public ReportEntity(String address, String category, String content, LocalDateTime createdAt, Long id, String phoneNumber) {
        this.address = address;
        this.category = category;
        this.content = content;
        this.createdAt = createdAt;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }
}
