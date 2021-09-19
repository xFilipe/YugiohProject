package com.yugioh.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class Inventario extends PanacheEntityBase {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany
    private Map<String, Carta> cartas = new HashMap<>();

    @ManyToMany
    private Map<String, Deck> decks = new HashMap<>();


    public Deck criarDeck(List<Carta> cartas, boolean usar){
        Deck deck = new Deck();

        if(cartas.size() == 39){
            deck.setDeckCartas(cartas);
           if(usar == true){
               deck.setDeckPrincipal(true);
           } else {
               deck.setDeckPrincipal(false);
           }
           return deck;
        } else {
            return null;

        }

    }





}
