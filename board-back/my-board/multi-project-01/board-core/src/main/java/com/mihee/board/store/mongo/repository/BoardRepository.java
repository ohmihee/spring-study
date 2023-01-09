package com.mihee.board.store.mongo.repository;

import com.mihee.board.store.mongo.repository.doc.BoardDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface BoardRepository extends MongoRepository<BoardDoc, String> {
}
