package com.agendabierta.domain.exceptions;

public class DomainConstraintViolationException extends RuntimeException {

    public DomainConstraintViolationException(String detail) {
        super(detail);
    }
}
