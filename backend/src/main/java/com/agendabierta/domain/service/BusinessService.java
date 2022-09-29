package com.agendabierta.domain.service;

import com.agendabierta.domain.model.Business;
import com.agendabierta.domain.model.Job;
import com.agendabierta.infrastructure.data.entity.JobEntity;

import java.util.List;

public interface BusinessService {
    public void registerBusiness(Business business);
    public void registerJobInBusiness(Job job, Long businessId);
    public void deleteJobInBusiness(Long jodId);
    public List<JobEntity> getAllJobs();
}
