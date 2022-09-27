package com.agendabierta.infrastructure.api.dto;

import com.agendabierta.domain.model.User;
import lombok.Data;

@Data
public class CreationUserDto {
    private String username;
    private String email;
    private String password;

    public User toModel(){
        User user = User.builder().username(username)
                .email(email).password(password).build();
        return user;
    }
}
