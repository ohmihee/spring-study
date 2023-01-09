package com.mihee.board.store.mongo.impl;

import com.mihee.board.domain.Board;
import com.mihee.board.store.mongo.BoardStore;
import com.mihee.board.store.mongo.repository.BoardRepository;
import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class BoardStoreImpl implements BoardStore {

    private final BoardRepository boardRepository;

    public void create(Board board) {
        BoardDoc boardDoc = new BoardDoc(board);
        this.boardRepository.save(boardDoc);
    }

    public Board findById(String id) {
        Optional<BoardDoc> boardDoc = this.boardRepository.findById(id);
        return boardDoc.map(BoardDoc::toDomain).orElse(null);
    }

    public void modify(Board board) {
        BoardDoc boardDoc = new BoardDoc(board);
        this.boardRepository.save(boardDoc);
    }

    public Boolean isExist (String id) {
        return this.boardRepository.findById(id).isPresent();
    }

    public List<Board> findAll () {
        return BoardDoc.toDomains(this.boardRepository.findAll());
    }

}
