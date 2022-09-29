package com.agendabierta.domain.service;

import com.agendabierta.domain.model.Business;
import com.agendabierta.domain.model.Job;
import com.agendabierta.infrastructure.data.entity.BusinessEntity;
import com.agendabierta.infrastructure.data.entity.JobEntity;
import com.agendabierta.infrastructure.data.repository.BusinessRepository;
import com.agendabierta.infrastructure.data.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImp implements BusinessService{
    @Autowired
    BusinessRepository businessRepository;
    @Autowired
    JobRepository jobRepository;

    @Override
    public void registerBusiness(Business business) {
        businessRepository.save(new BusinessEntity(business));
    }

    @Override
    public void registerJobInBusiness(Job job, Long businessId) {
        jobRepository.save(new JobEntity(job));
    }

    @Override
    public void deleteJobInBusiness(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    @Override
    public List<JobEntity> getAllJobs() {
        return jobRepository.findAll();
    }
}
