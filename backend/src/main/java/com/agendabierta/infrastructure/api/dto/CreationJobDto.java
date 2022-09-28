package com.agendabierta.infrastructure.api.dto;

import com.agendabierta.domain.model.Business;
import com.agendabierta.domain.model.Job;
import com.agendabierta.domain.model.Turn;
import lombok.Data;

@Data
public class CreationJobDto {
    private String name;
    private Integer cost;
    private String description;
    private Long businessId;

    public Job toModel() {
        Job aux = Job.builder().name(name).cost(cost)
                .description(description).build();
        return aux;
    }
}
