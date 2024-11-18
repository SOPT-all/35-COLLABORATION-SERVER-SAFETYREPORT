package com.safetyreport.safetyreport.domain;

import lombok.Getter;

@Getter
public enum Category {
    SAFETY("안전"),
    PARKING("불법주정차"),
    TRAFFIC("교통위반"),
    LIFE("생활불편");

    public final String description;

    Category(String description) {
        this.description = description;
    }
}
