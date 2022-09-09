package com.agendabierta.service;

import com.agendabierta.model.User;
import com.agendabierta.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity registerUser(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        try{
            return ResponseEntity.ok(userRepository.save(newUser));
        }catch(Error err) {
            err.printStackTrace();
            return ResponseEntity.status(500).body("Ya existe un usuario con ese email");
        }
    }

    @Override
    public ResponseEntity<User> getUser(String email) {
        try{
            User user = userRepository.findByEmail(email);
            if(user == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.ok(user);
        }catch(Error err){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<User> updateUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null){
            User userChanged = userRepository.save(user);
            return ResponseEntity.ok(userRepository.save(userChanged));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void deleteUser(String email) {
        try{
            User userToDelete = userRepository.findByEmail(email);
            userRepository.delete(userToDelete);
        }catch (Error err){
            System.out.println(err.toString());
        }
    }
}
