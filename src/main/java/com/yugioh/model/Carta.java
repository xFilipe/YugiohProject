package com.yugioh.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Carta extends PanacheEntityBase {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private String tipoCarta;
    private String tipo;
    private int nivel;
    private int ataque;
    private int defesa;
    private int password;
    private int preco;
    private boolean status = false; // Verifica se a carta está em jogo.

}
