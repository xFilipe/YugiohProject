package com.yugioh.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


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
        duelo.setDuelista2(d2.getId());

        // Teste
        Date date = new Date();
        duelo.setId(date.getTime());


        arena.setTipoCampo("0");
        arena.setPontoVida1(8000);
        arena.setPontoVida2(8000);
        arena.setJogador1(d1.getId());
        arena.setJogador2(d2.getId());


        // Sortear
        List<Long> moeda = new ArrayList<>(1);
        moeda.add(d1.getId());
        moeda.add(d2.getId());
        Collections.shuffle(moeda);
        long sorteado = moeda.get(0);

        playerOne = d1;
        playerOne.getDeckAtual().embaralhar();
        for(int i = 0; i < 3; i++){
            playerOne.getMao().add(playerOne.getDeckAtual().sacar());
        }

        playerTwo = d2;
        playerTwo.getDeckAtual().embaralhar();
        for(int i = 0; i < 3; i++){
            playerTwo.getMao().add(playerTwo.getDeckAtual().sacar());
        }

        mudarJogador(sorteado);
        return duelo;
    }

    public void mudarJogador(long id){
        if(id == playerOne.getId()){
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
        mudarTurno(currentPlayer.getId());
    }

    public void mudarTurno(long cp){
        if (playerOne.getId() == cp){
            if (playerOne.getMao().size() < 4) {
                playerOne.getMao().add(playerOne.getDeckAtual().sacar());
            } else {
                arena.getCemiterio1().add(playerOne.getDeckAtual().sacar());
            }

        } else if(playerTwo.getId() == cp){
            if(playerTwo.getMao().size() < 4){
                playerTwo.getMao().add(playerTwo.getDeckAtual().sacar());
            } else {
                arena.getCemiterio2().add(playerTwo.getDeckAtual().sacar());
            }
        }
        arena.setContador(arena.getContador() + 1);
    }

    // c = carta, j = id jogador, p = posicao no campo, v = virada para cima ou baixo
    public void jogarCarta(Carta c, long j, String p, boolean v){
        boolean jogou; // irá impedir que mais de um monstro seja jogado.

        if (playerOne.getId() == j){
            if (c.getTipo() == "Monster"){
                jogou = true;
                if(arena.getAreaMonstro1().isEmpty()){
                    c.setCartaVirada(v);
                    c.setStatus(true);
                    arena.getAreaMonstro1().put(p, c);
                } else if(arena.getAreaMonstro1().containsKey(p)) {
                    c.setCartaVirada(v);
                    c.setStatus(true);
                    arena.getAreaMonstro1().replace(p, c);
                }

            }else if(c.getTipo() == "Equip"){
                // equip
            } else {
                // trap or magic
            }
        
        

        }




    }




    // Rever
    public void atacar(Carta at, Carta df){
        if(at.getAtaque() > df.getDefesa()){

        }

    }


    public Duelo encerrar(){
        Duelo duelo = new Duelo();
        duelo.setStatus(false);

        if(arena.getPontoVida1() == 0){
             duelo.setVencedorId(playerOne.getId());
        } else if (arena.getPontoVida2() == 0){
            duelo.setVencedorId(playerTwo.getId());
        }

        duelo.setHoraFim(LocalDate.now());
        return duelo;
    }




}
