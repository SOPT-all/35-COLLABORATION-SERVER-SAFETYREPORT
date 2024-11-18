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
public class PictureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "photo_url")
    public String photoUrl;

    @Column(name = "created_at")
    public LocalDateTime createdAt;

    @Builder
    public PictureEntity(LocalDateTime createdAt, Long id, String photoUrl) {
        this.createdAt = createdAt;
        this.id = id;
        this.photoUrl = photoUrl;
    }
}
