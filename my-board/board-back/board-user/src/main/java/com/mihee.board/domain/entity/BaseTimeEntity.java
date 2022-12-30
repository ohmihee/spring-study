package com.example.back.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
public abstract class BaseTimeEntity {

    @CreatedDate
    private Long createDateTime;

    @LastModifiedDate
    private Long lastModifiedDate;
}
