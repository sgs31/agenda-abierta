package com.agendabierta.service;

import com.agendabierta.infrastructure.data.entity.User;
import com.agendabierta.infrastructure.data.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    IUserRepository userRepository;

    @Test
    public void getUserIncorrect(){
        User found2 = userRepository.findByUsername("aguslop");
        User found = userRepository.findByUsername("dada");

        System.out.println(found);
        System.out.println(found2);
    }

}