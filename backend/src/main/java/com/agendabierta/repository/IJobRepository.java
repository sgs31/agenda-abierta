package com.agendabierta.repository;

import com.agendabierta.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobRepository extends JpaRepository<Job, Long> {
}
