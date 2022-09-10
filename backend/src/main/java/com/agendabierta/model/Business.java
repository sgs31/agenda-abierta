package com.agendabierta.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "business")
public class Business {
    @Id
    @SequenceGenerator(name = "business_sequence", sequenceName = "business_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "business_id")
    private Long businessId;
    @Column(unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id", referencedColumnName = "businessId")
    private List<Turn> turns;
}
