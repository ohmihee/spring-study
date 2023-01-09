package com.mihee.board.domain;

import com.mihee.board.domain.vo.BoardContent;
import lombok.*;
import java.util.List;

//@Data
// @Getter @Setter @ToString @EqualsAndHashCod @RequiredArgsConstructor
// @Data
@Getter
@NoArgsConstructor
public class Board extends BaseEntity {

    private String category;
    private String title;
    private List<BoardContent> contents;
    private String writer;
    private String user;

}
