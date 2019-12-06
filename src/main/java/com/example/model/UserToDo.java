package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserToDo {

    private String username;
    private String password;
    private String password2;
    private String email;
    private String beschreibung;
    private String pic;
}
