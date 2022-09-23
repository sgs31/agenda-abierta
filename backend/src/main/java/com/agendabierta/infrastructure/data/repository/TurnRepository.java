package com.agendabierta.infrastructure.data.repository;

import com.agendabierta.infrastructure.data.entity.TurnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends JpaRepository<TurnEntity, Long> {
}
