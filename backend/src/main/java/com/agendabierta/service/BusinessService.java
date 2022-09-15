package com.agendabierta.service;

import com.agendabierta.model.Business;
import com.agendabierta.model.Job;
import com.agendabierta.repository.IBusinessRepository;
import com.agendabierta.repository.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BusinessService implements IBusinessService{

    @Autowired
    IBusinessRepository businessRepository;
    @Autowired
    IJobRepository jobRepository;
    @Override
    public Business registerBusiness(Business business) {
        return businessRepository.save(business);
    }
    @Override
    public Job registerJob(Job job) {
        Job aux = jobRepository.save(job);
        return aux;
    }

}
