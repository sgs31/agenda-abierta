package com.agendabierta.model;

import com.sun.istack.NotNull;
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
    @NotNull
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<Turn> turns;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<Job> jobs;
}
