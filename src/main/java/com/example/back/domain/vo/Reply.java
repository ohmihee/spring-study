package com.example.back.domain.vo;

import com.example.back.domain.entity.BaseTimeEntity;

public class Reply extends BaseTimeEntity {
    private String replierId;
    private String contents;
    private OpenStatus openStatus;
}
