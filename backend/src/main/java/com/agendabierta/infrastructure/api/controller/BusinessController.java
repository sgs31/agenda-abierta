package com.agendabierta.infrastructure.api.controller;

import com.agendabierta.domain.service.BusinessService;
import com.agendabierta.infrastructure.api.dto.CreationBusinessDto;
import com.agendabierta.infrastructure.api.dto.CreationJobDto;
import com.agendabierta.infrastructure.data.entity.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business")
public class BusinessController {
    @Autowired
    BusinessService businessService;

    @PostMapping("/")
    public void registerBusiness(@RequestBody CreationBusinessDto businessDto){
        businessService.registerBusiness(businessDto.toModel());
    }

    @PostMapping("/jobs")
    public void registerJob(@RequestBody CreationJobDto jobDto){
        businessService.registerJobInBusiness(jobDto.toModel(), jobDto.getBusinessId());
    }

    @GetMapping("/jobs")
    public List<JobEntity> getJobs(){
        return businessService.getAllJobs();
    }

    @DeleteMapping("/jobs/{id}")
    public void deleteJob(@PathVariable Long id){
        businessService.deleteJobInBusiness(id);
    }
}
