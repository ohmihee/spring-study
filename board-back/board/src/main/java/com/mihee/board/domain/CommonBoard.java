package com.mihee.board.domain;

import com.mihee.board.domain.vo.BoardType;
import com.mihee.board.domain.vo.Content;
import com.mihee.board.domain.vo.OpenStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Board")
@AllArgsConstructor
public class CommonBoard extends BaseEntity {
    private String title;
    private BoardType boardType;
    private Long hits;
    private List<Content> contents;
    private OpenStatus openStatus;
}
// id
// 생성일 수정일
// 제목 title
// 내용 Content
// boardType -> 카테고리
// hits -> 조회수
//


// 일반/공지 title (title) / FAQ (질문) / Q&A (질문제목)
// 일반/공지 contents(전체 contents) / FAQ (질문 / 답변) / Q&A(질문 답변)
// category (일반, 공지, faq, q&a)
// writer 일반/공지 작성자  / FAQ(작성자) / Q&A(질문작성자, 답변 작성자)
// datetime 일반/공지 글작성일 / FAQ(글작성일) / Q&A(질문등록일, 질문답변일)
// 게시판 조회 등 정보 일반/공지 (hits/likes/hates) / FAQ(hits) / Q&A(hits)
// 글 공개여부 일반/공지 (public/onlyAdmin/onlyWriter) / FAQ(public/onlyAdmin) / Q&A(public/onlyWriter/onlyAdmin)
//
// 필요에 의해 만들 것
// flow는 가능하면 로직없이 flow만 보여주도록