package com.agendabierta.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Job {
    private Long jobId;
    private String name;
    private Integer cost;
    private String description;
    private Business business;
    private Turn turn;
}
