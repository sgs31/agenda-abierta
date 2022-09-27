package com.agendabierta.infrastructure.api.http_errors;

import com.agendabierta.domain.exceptions.DomainConstraintViolationException;
import com.agendabierta.domain.exceptions.NotFoundException;
import org.hibernate.DuplicateMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
                    DomainConstraintViolationException.class
            })
    @ResponseBody
    public ErrorMessage badRequest(Exception exception) {
        return new ErrorMessage(exception, HttpStatus.BAD_REQUEST.value());
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({
            DuplicateMappingException.class
    })
    @ResponseBody
    public ErrorMessage notAcceptable(Exception exception) {
    return new ErrorMessage(exception, HttpStatus.NOT_ACCEPTABLE.value());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            NotFoundException.class
    })
    @ResponseBody
    public ErrorMessage notFound(Exception exception) {
        return new ErrorMessage(exception, HttpStatus.NOT_ACCEPTABLE.value());
    }

}
