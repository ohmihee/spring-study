package com.example.back.domain;

import com.example.back.domain.vo.UserRole;
import org.springframework.data.annotation.Id;

import java.util.List;

public class User {
    @Id
    private String id;
    private String email;
    private String nick;
    private String password;
    private List<String> likes;
    private List<String> hates;
    private UserRole role = UserRole.SILVER;
}
