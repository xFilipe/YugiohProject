package com.yugioh.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Inventario extends PanacheEntityBase {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany
    private List<Carta> cartas = new ArrayList<>();

    @ManyToMany
    private List<Deck> decks = new ArrayList<>();


}
