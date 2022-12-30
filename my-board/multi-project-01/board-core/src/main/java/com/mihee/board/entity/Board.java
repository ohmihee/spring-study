package com.mihee.board.entity;

import ch.qos.logback.core.joran.spi.DefaultClass;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data
// @Getter @Setter @ToString @EqualsAndHashCod @RequiredArgsConstructor
@Data
@NoArgsConstructor
public class Board {

    @Id
    private String _id;
    private Long createDateTime;
    private Long lastModifiedDateTime;
    private String title;
    private String contents;


}
