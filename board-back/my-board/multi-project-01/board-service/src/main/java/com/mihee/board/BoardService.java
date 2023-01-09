package com.mihee.board;

import com.mihee.board.domain.Board;
import com.mihee.board.store.mongo.BoardStore;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardStore boardStore;

    public void createBoard(Board board) {
        System.out.println(board);
        this.boardStore.create(board);
    }


}
