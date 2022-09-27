package com.agendabierta.domain.service;

import com.agendabierta.domain.model.Turn;
import com.agendabierta.infrastructure.data.entity.TurnEntity;

import java.util.Date;
import java.util.List;

public interface TurnService {
    public void registerTurn(Long userId, Long businessId, Long jobId, Date date);
    public List<TurnEntity> getTurnsOfBusiness(Long businessId);
    public List<TurnEntity> getTurnsOfCustomer(Long userId);
    public void cancelTurn(Long turnId);
}
