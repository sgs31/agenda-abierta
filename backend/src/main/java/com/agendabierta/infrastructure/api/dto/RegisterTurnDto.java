package com.agendabierta.infrastructure.api.dto;

import com.agendabierta.domain.model.Turn;
import lombok.Data;

import java.util.Date;

@Data
public class RegisterTurnDto {
    private Date date;
    private Long userId;
    private Long businessId;
    private Long jobId;
}
