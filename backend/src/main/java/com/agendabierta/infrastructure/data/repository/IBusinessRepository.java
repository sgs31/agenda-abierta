package com.agendabierta.infrastructure.data.repository;

import com.agendabierta.infrastructure.data.entity.BusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusinessRepository extends JpaRepository<BusinessEntity, Long> {
}
