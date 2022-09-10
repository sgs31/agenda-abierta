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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id", referencedColumnName = "businessId")
    private Business business;
    @OneToOne(mappedBy = "turn")
    private BusinessService service;

}