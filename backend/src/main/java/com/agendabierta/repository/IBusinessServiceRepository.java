package com.agendabierta.repository;

import com.agendabierta.model.BusinessService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusinessServiceRepository extends JpaRepository<BusinessService, Long> {
}
