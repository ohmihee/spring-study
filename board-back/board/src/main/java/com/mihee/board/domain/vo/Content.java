package com.mihee.board.domain.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
public class Content {
    private String contentTitle;
    private String contentMain;
    private String writerName;
    @CreatedDate
    private long createDateTime;
}
