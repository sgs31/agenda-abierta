package com.agendabierta.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "turns")
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "turn_id")
    private Long id;
    private Date date;
    private User user;
    private Business business;
    private BusinessService service;

}
