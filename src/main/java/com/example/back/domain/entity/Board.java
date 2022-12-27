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
