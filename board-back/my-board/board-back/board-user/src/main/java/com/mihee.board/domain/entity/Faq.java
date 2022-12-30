package com.example.back.domain.entity;

import com.example.back.domain.vo.Category;
import com.example.back.domain.vo.OpenStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Faq")
public class Faq extends BaseTimeEntity{
    @Id
    private String id;
    private String question;
    private String answer;
    private OpenStatus openStatus;
    private Category category;
}
