package com.safetyreport.domain.entity.enums;

import lombok.Getter;

@Getter
public enum CategoryEnum {
    SAFETY("안전"),
    PARKING("불법주정차"),
    TRAFFIC("교통위반"),
    LIFE("생활불편");

    public final String description;

    CategoryEnum(String description) {
        this.description = description;
    }
}
