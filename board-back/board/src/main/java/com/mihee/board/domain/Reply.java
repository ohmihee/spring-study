package com.mihee.board.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Reply")
public class Reply extends BaseEntity{
    private String boardId;
    private String writerName;
    private String content;
}
