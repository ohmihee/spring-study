package com.mihee.board.common;

import com.mihee.board.entity.Board;
import com.mihee.board.store.BoardRepository;
import com.mihee.board.store.doc.BoardDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board/common")
@RequiredArgsConstructor
public class CommonController {

    private final BoardRepository boardRepository;

    @PostMapping("/register")
    public ResponseEntity registerCommonBoard (@RequestBody Board board) {
//        Board convertBoard = Board.builder()
//                ._id(board.get_id())
//                .createDateTime(board.getCreateDateTime())
//                .title(board.getTitle())
//                .contents(board.getContents())
//                .build();
//        Board.modifyContents()
     //   String newBoard = this.boardRepository.save(board).toString();
        BoardDoc boardDoc = new BoardDoc(board);
        BoardDoc result = this.boardRepository.save(boardDoc);
        result.toDomain();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/modify")
    public ResponseEntity modifyCommonBoard (@RequestBody Board board ) {

        return ResponseEntity.ok().body("");
    }
}
