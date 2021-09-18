package com.yugioh.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Deck extends PanacheEntityBase {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String deckNome;

    @ManyToMany
    List<Carta> deckCartas = new ArrayList<Carta>(39);

    public boolean adicionarCarta(Carta card){
        boolean mReturn;
        if(deckCartas.size() < 39) {
            deckCartas.add(card);
            mReturn = true;
        } else {
            mReturn = false;
        }
        return mReturn;
    }



    public Carta sacar(){
        Carta c = deckCartas.get(0);
        deckCartas.remove(0);
        return c;
    }


    public void embaralhar(){
        Collections.shuffle(deckCartas);
    }







}
