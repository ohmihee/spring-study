package com.example.back.domain.entity;

import com.example.back.domain.vo.OpenStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Qna")
public class Qna extends BaseTimeEntity{
    @Id
    private String id;
    private String writerId;
    private String question;
    private String answerId;
    private String answer;
    private OpenStatus openStatus;
    private Long resopnseDate;
}
