package com.agendabierta.infrastructure.api.dto;

import com.agendabierta.domain.model.Business;

public class CreationBusinessDto {
    private String name;

    public Business toModel(){
        Business aux = Business.builder()
                .name(name).build();
        return aux;
    }
}
