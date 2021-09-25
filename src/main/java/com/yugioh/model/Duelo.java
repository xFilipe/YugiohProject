package com.yugioh.model;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@Entity
public class Duelo extends PanacheEntityBase {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;


    private boolean status = false;

    private LocalDate horaInicio;
    private LocalDate horaFim;

    private long vencedorId;


    private long duelista1;

    private long duelista2;




}
