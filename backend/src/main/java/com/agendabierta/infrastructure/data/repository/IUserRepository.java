package com.agendabierta.infrastructure.data.repository;

import com.agendabierta.infrastructure.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity findByEmail(String email);
    public UserEntity findByUsername(String username);

    //spring.profiles.active=dev
}
