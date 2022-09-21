package com.agendabierta.infrastructure.data.repository;

import com.agendabierta.infrastructure.data.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobRepository extends JpaRepository<JobEntity, Long> {
}
