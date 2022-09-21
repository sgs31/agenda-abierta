package com.agendabierta.infrastructure.data.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "business")
public class BusinessEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "business_id")
    private Long businessId;
    @Column(unique = true)
    @NotNull
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<TurnEntity> turns;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<JobEntity> jobs;
}
