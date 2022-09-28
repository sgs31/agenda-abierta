package com.agendabierta.infrastructure.api.controller;

import com.agendabierta.domain.service.BusinessService;
import com.agendabierta.infrastructure.api.dto.CreationBusinessDto;
import com.agendabierta.infrastructure.api.dto.CreationJobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/jobs/{id}")
    public void deleteJob(@PathVariable Long id){
        businessService.deleteJobInBusiness(id);
    }
}
