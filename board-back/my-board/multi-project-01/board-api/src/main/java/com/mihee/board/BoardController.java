package com.mihee.board;

import com.mihee.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/command")
    public void createBoard(@RequestBody Board board) {
        System.out.println(board);
        this.boardService.createBoard(board);
    }

}
