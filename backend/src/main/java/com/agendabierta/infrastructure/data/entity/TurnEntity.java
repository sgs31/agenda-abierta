package com.agendabierta.infrastructure.data.entity;

import com.agendabierta.domain.model.Turn;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "turns")
public class TurnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "turn_id")
    private Long id;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id")
    private BusinessEntity business;
    @OneToOne(mappedBy = "turn")
    private JobEntity job;

    public TurnEntity(Turn turn){
        BeanUtils.copyProperties(turn, this);
    }

    public Turn toModel(){
        Turn turn = Turn.builder().build();
        BeanUtils.copyProperties(this, turn);
        return turn;
    }

}
