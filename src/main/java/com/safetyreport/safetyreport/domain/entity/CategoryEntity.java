package com.safetyreport.safetyreport.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "category_name")
    public String name;

    @Column(name = "category_description")
    public String description;

    public CategoryEntity(String description, Long id, String name) {
        this.description = description;
        this.id = id;
        this.name = name;
    }
}
