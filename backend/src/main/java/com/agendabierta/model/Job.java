package com.agendabierta.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "job_id")
    private Long jobId;
    @NotNull
    private String name;
    @NotNull
    private Integer cost;
    @NotNull
    private String description;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id")
    private Business business;
    @OneToOne
    @JoinColumn(name = "turn_id")
    private Turn turn;
}
