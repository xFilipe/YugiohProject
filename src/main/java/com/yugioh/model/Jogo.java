package com.yugioh.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Getter
@Setter
@ToString
public class Jogo {

    private Duelista playerOne;
    private Duelista playerTwo;
    private Duelista currentPlayer;
    private Arena arena;



    public Duelo comecar(Duelista d1, Duelista d2){

        Duelo duelo = new Duelo();
        duelo.setStatus(true);
        duelo.setHoraInicio(LocalDate.now());
        duelo.setDuelista1(d1.getId());
        duelo.setVencedorId(0l);
        duelo.setDuelista2(d2.getId());
        //duelo.setId(); ver

        arena.setTipoCampo("0");
        arena.setPontoVida1(8000);
        arena.setPontoVida2(8000);


        // Sortear
        List<Long> moeda = new ArrayList<>();
        moeda.add(d1.getId());
        moeda.add(d2.getId());
        Collections.shuffle(moeda);
        long sorteado = (long) moeda.get(0);
        mudarJogador(sorteado);

        playerOne = d1;
        playerTwo = d2;

        playerOne.getDeckAtual().g

        return duelo;
    }

    public void mudarJogador(long id){
        if(id == playerOne.getId()){
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }

    public void mudarTurno(){

        currentPlayer.getDeckAtual().g
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
