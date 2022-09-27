package com.agendabierta.infrastructure.data.entity;

import com.agendabierta.domain.model.User;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long userId;
    @Column(unique = true)
    @NotNull
    private String username;
    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    @Column(length = 8)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TurnEntity> turns;

    public UserEntity(User user){
        BeanUtils.copyProperties(user, this);
    }

    public User toModel(){
        User user = User.builder().build();
        BeanUtils.copyProperties(this, user);
        return user;
    }
}
