package com.agendabierta.controller;

import com.agendabierta.model.User;
import com.agendabierta.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        try{
            User aux = userService.registerUser(user);
            return new ResponseEntity(aux, HttpStatus.OK);
        }catch (Error err){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
