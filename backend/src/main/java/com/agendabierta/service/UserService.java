package com.agendabierta.service;

import com.agendabierta.model.User;
import com.agendabierta.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<User> registerUser(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userRepository.save(newUser));
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
        if(userRepository.existByEmail(user.getEmail())){
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
