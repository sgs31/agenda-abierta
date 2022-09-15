package com.agendabierta.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @NotNull
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id")
    private Business business;
    @OneToOne(mappedBy = "turn")
    private Job job;

}
