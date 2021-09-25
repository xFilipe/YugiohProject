package com.yugioh.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Arena {

    private String tipoCampo;

    private int contador;

    // Player One
    private long jogador1;
    private int pontoVida1;
    Map<String, Carta> areaMonstro1 = new HashMap<>(4);
    Map<String, Carta> areaMagia1 = new HashMap<>(4);
    List<Carta> cemiterio1 = new ArrayList<>(39);


    // Player Two
    private long jogador2;
    private int pontoVida2;
    Map<String, Carta> areaMonstro2 = new HashMap<>(4);
    Map<String, Carta> areaMagia2 = new HashMap<>(4);
    List<Carta> cemiterio2 = new ArrayList<>(39);



}
