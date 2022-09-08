package com.agendabierta.service;

import com.agendabierta.model.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    public ResponseEntity<User> registerUser(User user);
    public ResponseEntity<User> getUser(String email);
    public ResponseEntity<User> updateUser(User user);
    public void deleteUser(String email);
}
