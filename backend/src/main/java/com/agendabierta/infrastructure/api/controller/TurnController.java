package com.agendabierta.infrastructure.api.controller;

import com.agendabierta.domain.service.TurnService;
import com.agendabierta.infrastructure.api.dto.RegisterTurnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/turns")
public class TurnController {
    @Autowired
    TurnService turnService;

    @PostMapping("/")
    public void registerTurn(@RequestBody RegisterTurnDto turnDto){
        final Long userId = turnDto.getUserId();
        final Long businessId = turnDto.getBusinessId();
        final Long jobId = turnDto.getJobId();
        final Date date = turnDto.getDate();
        turnService.registerTurn(userId, businessId, jobId, date);
    }
}
