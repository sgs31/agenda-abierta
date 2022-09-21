package com.agendabierta.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Business {

    private Long businessId;
    private String name;
    /*private List<Turn> turns;
    private List<Job> jobs;*/

}
