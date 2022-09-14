package com.agendabierta.service;

import com.agendabierta.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    public User registerUser(User user);
    public List<User> getAllUsers();
    public User getUser(String email);
    public User updateUser(User user);
    public void deleteUser(String email);
}
