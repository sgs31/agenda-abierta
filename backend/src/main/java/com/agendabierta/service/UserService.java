package com.agendabierta.service;

import com.agendabierta.model.User;
import com.agendabierta.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        try{
            return userRepository.save(newUser);
        }catch(Error err) {
            err.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public User updateUser(User user) {
        User userChanged = userRepository.save(user);
        return userChanged;
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
