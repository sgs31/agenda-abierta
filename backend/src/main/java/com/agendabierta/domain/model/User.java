package com.agendabierta.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long UserId;
    private String username;
    private String email;
    private String password;
}
