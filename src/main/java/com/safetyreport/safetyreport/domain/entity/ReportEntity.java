package com.safetyreport.safetyreport.domain.entity;

import com.safetyreport.safetyreport.domain.Category;
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
    public Category category = Category.PARKING;

    @Column(name = "created_at")
    public LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    @ManyToOne(targetEntity = PhotoEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PhotoEntity photoEntity;

    @Builder
    public ReportEntity(String address, Category category, String content, LocalDateTime createdAt, Long id, String phoneNumber, UserEntity userEntity) {
        this.address = address;
        this.category = category;
        this.content = content;
        this.createdAt = createdAt;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.userEntity = userEntity;
    }
}
