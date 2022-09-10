package com.agendabierta.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "services")
public class BusinessService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "service_id")
    private Long bussinessServiceId;
    private String name;
    private Integer cost;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id", referencedColumnName = "businessId")
    private Business business;
}
