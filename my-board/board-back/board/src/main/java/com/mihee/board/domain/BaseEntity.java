package com.mihee.board.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

@Getter
@Setter
public abstract class BaseEntity {
    @Id
    private String _id;
    @CreatedDate
    private Long createDateTime;
    @LastModifiedDate
    private Long lastModifiedDate;
}
