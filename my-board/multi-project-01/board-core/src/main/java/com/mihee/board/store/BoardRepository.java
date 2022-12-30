package com.mihee.board.store;

import com.mihee.board.store.doc.BoardDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends MongoRepository<BoardDoc, String> {
}
