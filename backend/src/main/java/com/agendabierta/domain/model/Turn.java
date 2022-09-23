package com.agendabierta.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Turn {
    private Long id;
    private Date date;
    private User user;
    private Business business;
    private Job job;
}
