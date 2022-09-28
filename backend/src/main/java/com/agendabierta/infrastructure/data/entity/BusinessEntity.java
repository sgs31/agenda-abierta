package com.agendabierta.infrastructure.data.entity;

import com.agendabierta.domain.model.Business;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "business")
public class BusinessEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "business_id")
    private Long businessId;
    @Column(unique = true)
    @NotNull
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<TurnEntity> turns;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<JobEntity> jobs;

    public BusinessEntity(Business business){
        BeanUtils.copyProperties(business, this);
    }

    public Business toModel(){
        Business business = Business.builder().build();
        BeanUtils.copyProperties(this, business);
        return business;
    }
}
