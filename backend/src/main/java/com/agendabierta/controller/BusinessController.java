package com.agendabierta.controller;

import com.agendabierta.model.Business;
import com.agendabierta.model.Job;
import com.agendabierta.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

    @Autowired
    IBusinessService businessService;

    @PostMapping("/api/business")
    public ResponseEntity<Business> registerBusiness(@RequestBody Business business){
        try{
            Business businessRegistered = businessService.registerBusiness(business);
            return new ResponseEntity(businessRegistered, HttpStatus.OK);
        }catch(Error err){
            err.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/api/service")
    public ResponseEntity<Business> registerJob(@RequestBody Job job){
        try{
            Job jobRegistered = businessService.registerJob(job);
            return new ResponseEntity(jobRegistered, HttpStatus.OK);
        }catch(Error err){
            err.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


}
