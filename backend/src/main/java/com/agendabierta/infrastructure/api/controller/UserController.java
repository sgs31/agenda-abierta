package com.agendabierta.infrastructure.api.controller;

import com.agendabierta.domain.service.UserService;
import com.agendabierta.infrastructure.api.dto.CreationUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody CreationUserDto creationUserDto){
        userService.registerUser(creationUserDto.toModel());
    }
}
