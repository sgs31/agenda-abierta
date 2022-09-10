package com.agendabierta.repository;

import com.agendabierta.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusinessRepository extends JpaRepository<Business, Long> {
}
