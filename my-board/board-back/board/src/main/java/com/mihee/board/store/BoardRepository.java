package com.mihee.board.store;

import com.mihee.board.domain.CommonBoard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends MongoRepository<CommonBoard, String> {
}
