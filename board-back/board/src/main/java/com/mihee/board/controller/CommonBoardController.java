package com.mihee.board.controller;

import com.mihee.board.domain.CommonBoard;
import com.mihee.board.store.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/board/common")
@AllArgsConstructor
public class CommonBoardController {

    private final BoardRepository boardRepository;

    @PostMapping("/register")
    public ResponseEntity addBoard(@RequestBody CommonBoard test) throws IllegalArgumentException {
        Optional<CommonBoard> board = this.boardRepository.findById(test.getId());
        board.ifPresent(ele -> ele.setHits(10l));
        this.boardRepository.save(board.get());
        //this.boardRepository.save(test);
        System.out.println(test);
        return ResponseEntity.ok().body("success");
    }

}
