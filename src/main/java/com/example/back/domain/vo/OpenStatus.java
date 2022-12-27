package com.example.back.domain.vo;

public enum OpenStatus {
    PUBLIC("PUBLIC"),
    ONLY_ADMIN("ONLY_ADMIN"),
    ONLY_WRITER("ONLY_WRITER"),
    ;

    private final String value;

    OpenStatus (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
