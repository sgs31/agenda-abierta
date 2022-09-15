package com.agendabierta.service;

import com.agendabierta.model.Business;
import com.agendabierta.model.Job;

public interface IBusinessService {
    public Business registerBusiness(Business bussiness);
    public Job registerJob(Job job);
}
