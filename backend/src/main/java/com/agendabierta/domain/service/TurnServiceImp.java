package com.agendabierta.domain.service;

import com.agendabierta.domain.exceptions.NotFoundException;
import com.agendabierta.domain.model.Business;
import com.agendabierta.domain.model.Job;
import com.agendabierta.domain.model.Turn;
import com.agendabierta.domain.model.User;
import com.agendabierta.infrastructure.data.entity.TurnEntity;
import com.agendabierta.infrastructure.data.repository.BusinessRepository;
import com.agendabierta.infrastructure.data.repository.JobRepository;
import com.agendabierta.infrastructure.data.repository.TurnRepository;
import com.agendabierta.infrastructure.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TurnServiceImp implements TurnService{
    @Autowired
    private TurnRepository turnRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobRepository jobRepository;

    @Override
    public void registerTurn(Long userId, Long businessId, Long jobId, Date date) {
        User user = userRepository.findById(userId).get().toModel();
        Business business = businessRepository.findById(businessId).get().toModel();
        Job job = jobRepository.findById(jobId).get().toModel();
        Turn turnToRegister = Turn.builder().user(user).business(business).job(job).date(date).build();
        if(business.isValidTurn(turnToRegister)) turnRepository.save(new TurnEntity(turnToRegister));
    }

    @Override
    public List<TurnEntity> getTurnsOfBusiness(Long businessId) {
        List<TurnEntity> turnsOnRepository = turnRepository.findAll();
        Stream<TurnEntity> businessTurns = turnsOnRepository.stream().filter(turnEntity -> turnEntity.getBusiness().getBusinessId() == businessId);
        return businessTurns.toList();
    }

    @Override
    public List<TurnEntity> getTurnsOfCustomer(Long userId) {
        List<TurnEntity> turnsOnRepository = turnRepository.findAll();
        Stream<TurnEntity> userTurns = turnsOnRepository.stream().filter(turnEntity -> turnEntity.getUser().getUserId() == userId);
        return userTurns.toList();
    }

    @Override
    public void cancelTurn(Long turnId) {
        if(!turnRepository.existsById(turnId)) throw new NotFoundException("No existe ese turno");
        Optional<TurnEntity> turn = turnRepository.findById(turnId);
        turnRepository.delete(turn.get());
    }
}
