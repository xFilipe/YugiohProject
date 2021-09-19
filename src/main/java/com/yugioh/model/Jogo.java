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

    private long horaInicio;
    private long horaFim;
    private Duelista vencedor;

    private Arena arena = new Arena();
    private Duelista duelista1 = new Duelista();
    private Duelista duelista2 = new Duelista();
    private Duelista jogadorAtual = new Duelista();



    public boolean comecar(Duelista d1, Duelista d2){

        duelista1 = d1;
        duelista2 = d2;

        this.status = true;


        Date hora = new Date();
        horaInicio = hora.getTime();

        arena.setTipoCampo("0");
        arena.setPontoVida1(8000);
        arena.setPontoVida2(8000);

        /*

        arena.getAreaMonstro1().clear();
        arena.getAreaMonstro2().clear();

        arena.getAreaMagia1().clear();
        arena.getAreaMagia2().clear();

         */


        // Sortear
        List<Long> moeda = new ArrayList<>();
        moeda.add(d1.getId());
        moeda.add(d2.getId());
        Collections.shuffle(moeda);
        long sorteado = moeda.get(0);
        trocarturno(sorteado);


        duelista1.getDeckAtual().sacar();
        duelista2.getDeckAtual().sacar();


        return true;
    }

    public void trocarturno(long id){
        if(id == duelista1.getId()){
            jogadorAtual = duelista2;
        } else {
            jogadorAtual = duelista1;
        }
    }

    public void encerrar(){
        status = false;
        if(arena.getPontoVida1() < arena.getPontoVida2()){
            vencedor = duelista2;
        } else {
            vencedor = duelista1;
        }

    }




}
