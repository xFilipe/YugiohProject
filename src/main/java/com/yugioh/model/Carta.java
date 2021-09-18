package com.yugioh.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class Carta extends PanacheEntity {

    private String nome;
    private int ataque;
    private int defesa;
    private String descricao;
    private boolean status = false; // Verifica se a carta está em jogo.
    // private Efeito efeito;
    // private Tipo tipo;



}
