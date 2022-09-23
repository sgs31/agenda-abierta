package com.agendabierta.infrastructure.data.repository;

import com.agendabierta.infrastructure.data.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Long> {
}
