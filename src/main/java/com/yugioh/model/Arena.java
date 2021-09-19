package com.yugioh.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Arena {

    private String tipoCampo;

    // Player One
    private Duelista jogador1;
    private int pontoVida1;
    Map<Integer, Carta> areaMonstro1;
    Map<Integer, Carta> areaMagia1;
    List<Carta> cemiterio1 = new ArrayList<>();


    // Player Two
    private Duelista jogador2;
    private int pontoVida2;
    Map<Integer, Carta> areaMonstro2;
    Map<Integer, Carta> areaMagia2;
    List<Carta> cemiterio2 = new ArrayList<>();



}
