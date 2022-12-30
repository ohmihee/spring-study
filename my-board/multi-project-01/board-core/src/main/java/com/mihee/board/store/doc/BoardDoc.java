package com.mihee.board.store.doc;

import com.mihee.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Board")
@Getter
@NoArgsConstructor
public class BoardDoc {
    @Id
    private String _id;
    @CreatedDate
    private Long createDateTime;
    @LastModifiedDate
    private Long lastModifiedDateTime;
    private String title;
    private String contents;

    public BoardDoc(Board board) {
        BeanUtils.copyProperties(board, this);
    }

    public Board toDomain() {
        Board board = new Board();
        BeanUtils.copyProperties(this, board);
        return board;
    }

}
