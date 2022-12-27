package com.example.back.domain.vo;

public enum UserRole {
    ADMIN("ADMIN"),
    SILVER("SILVER_USER"),  // 일반회원
    GOLD("GOLD_USER"), // 상위회원
    ;

    private final String value;
    UserRole(String value) {
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
