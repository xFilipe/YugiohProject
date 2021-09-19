package com.yugioh.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Getter
@Setter
public class Duelista extends PanacheEntityBase {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    @OneToOne
    private Inventario inventario;

    @ManyToMany
    private List<Carta> mao = new ArrayList<>();


}
