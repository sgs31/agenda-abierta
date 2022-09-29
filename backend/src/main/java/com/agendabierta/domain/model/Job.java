package com.agendabierta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
