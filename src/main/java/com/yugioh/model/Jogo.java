package com.yugioh.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Jogo {

    private boolean status = false; // Verifica se o jogo está em andamento
    private Duelista duelista1;
    private Duelista duelista2;
    private Duelista jogadorAtual;
    private Arena arena;
    private long horaInicio;
    private long horaFim;
    private Duelista vencedor;


    private void comecar(Long cara, Long coroa){

        this.status = true;


        Date hora = new Date();
        horaInicio = hora.getTime();

        arena.setTipoCampo("0");
        arena.setPontoVida1(8000);
        arena.setPontoVida2(8000);

        arena.getAreaMonstro1().clear();
        arena.getAreaMonstro2().clear();

        arena.getAreaMagia1().clear();
        arena.getAreaMagia2().clear();


        // Sortear
        List<Long> moeda = new ArrayList<>();
        moeda.add(cara);
        moeda.add(coroa);
        Collections.shuffle(moeda);
        long sorteado = moeda.get(0);
        trocarturno(sorteado);


        duelista1.getDeckAtual().sacar();
        duelista2.getDeckAtual().sacar();

    }

    private void trocarturno(long id){
        if(id == duelista1.getId()){
            jogadorAtual = duelista2;
        } else {
            jogadorAtual = duelista1;
        }
    }

    private void encerrar(){
        status = false;
        if(arena.getPontoVida1() < arena.getPontoVida2()){
            vencedor = duelista2;
        } else {
            vencedor = duelista1;
        }

    }




}
