package com.agendabierta.domain.service;

import com.agendabierta.domain.model.Business;
import com.agendabierta.domain.model.Job;

public interface BusinessService {
    public void registerBusiness(Business business);
    public void registerJobInBusiness(Job job, Long businessId);
    public void deleteJobInBusiness(Long jodId);
}
