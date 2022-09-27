package com.agendabierta.domain.model;

import com.agendabierta.domain.exceptions.DomainConstraintViolationException;
import com.agendabierta.domain.utils.DateUtil;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Data
@Builder
public class Business {

    private Long businessId;
    private String name;
    private List<Turn> turns;
    private List<Job> jobs;

    public boolean isValidTurn(Turn turn){
        if(DateUtil.isInvalidDate(turn.getDate())) throw new DomainConstraintViolationException("Fecha invalida");
        if(!isCustomerCanGetTurn(turn.getUser(), turn.getDate())) throw new DomainConstraintViolationException(
                "El usuario no puede tener dos turnos el mismo dia."
        );
        return true;
    }

    public boolean isCustomerCanGetTurn(User customer, Date date){
        AtomicBoolean ret = new AtomicBoolean(true);
        turns.stream().forEach(turn -> {
            boolean userHasATurn = turn.getUser().equals(customer);
            if(userHasATurn){
                boolean twoTurnInSameDay = DateUtil.isSameDay(date, turn.getDate());
                if(twoTurnInSameDay) ret.set(false);
            }
        });
        return ret.get();
    }


}
