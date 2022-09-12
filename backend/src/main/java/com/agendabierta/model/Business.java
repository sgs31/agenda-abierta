package com.agendabierta.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "business_id")
    private Long businessId;
    @Column(unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<Turn> turns;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<BusinessService> services;
}
