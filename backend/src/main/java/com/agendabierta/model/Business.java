package com.agendabierta.model;

import javax.persistence.*;

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
}
