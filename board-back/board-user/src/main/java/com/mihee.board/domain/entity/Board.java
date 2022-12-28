package com.example.back.domain.entity;

import com.example.back.domain.vo.BoardInfo;
import com.example.back.domain.vo.Category;
import com.example.back.domain.vo.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Board")
public class Board extends BaseTimeEntity{
    @Id
    private String id;
    private String title;
    private String contents;
    private Category category;
    private BoardInfo infos;
    private String writerId;
    private Reply reply;
}
// 일반/공지 title (title) / FAQ (질문) / Q&A (질문제목)
// 일반/공지 contents(전체 contents) / FAQ (질문 / 답변) / Q&A(질문 답변)
// category (일반, 공지, faq, q&a)
// writer 일반/공지 작성자  / FAQ(작성자) / Q&A(질문작성자, 답변 작성자)
// datetime 일반/공지 글작성일 / FAQ(글작성일) / Q&A(질문등록일, 질문답변일)
// 게시판 조회 등 정보 일반/공지 (hits/likes/hates) / FAQ(hits) / Q&A(hits)
// 글 공개여부 일반/공지 (public/onlyAdmin) / FAQ(public/onlyAdmin) / Q&A(public/onlyWriter/onlyAdmin)
//
// 필요에 의해 만들 것
// flow는 가능하면 로직없이 flow만 보여주도록

/**
 *
 * common-board
 * All-board
 * private String id;
 * private String title;
 * private BoardType boardType;
 * private Long hits;
 * private List<Contents> contents
 * ---------------------------------------------------------------
 * reply
 * private String id;
 * private String contentId;
 * private String writerName;
 * private LocalDateTime createdBy;
 * private LocalDateTime updatedBy;
 *
 * */

// vo
/**
 * Contents
 * private String contentTitle // 일반 공지 질문 답변
 * private String contentMain // 안녕하세요 안녕하세요 어떻게 등업을 하나요 이렇게 하세요
 * private String writerName // (사용자) (관리자) (관리자 관리자) (사용자 관리자)
 *
 *
 * */

/**
 * openstatus (enum)
 * // (public/onlyAdmin) / FAQ(public/onlyAdmin) / Q&A(public/onlyWriter/onlyAdmin)
 * private String open_public
 * private String open_Admin
 * private String open_WriterAndAdmin
 *
 *
 *
 * */