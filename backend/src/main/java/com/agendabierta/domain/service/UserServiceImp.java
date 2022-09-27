package com.agendabierta.domain.service;

import com.agendabierta.domain.model.User;
import com.agendabierta.infrastructure.data.entity.UserEntity;
import com.agendabierta.infrastructure.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        userRepository.save(new UserEntity(user));
    }
}
