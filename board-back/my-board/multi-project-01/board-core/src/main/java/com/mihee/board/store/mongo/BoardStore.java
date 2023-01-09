package com.mihee.board.store.mongo;

import com.mihee.board.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardStore {
    void create (Board board);
    Board findById (String id);

    void modify (Board board);

    Boolean isExist(String id);
    List<Board> findAll ();
}
