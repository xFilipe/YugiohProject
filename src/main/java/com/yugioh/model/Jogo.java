package com.yugioh.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

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



    public boolean comecar(@NotNull Duelista d1, @NotNull Duelista d2){

        duelista1 = d1;
        duelista2 = d2;

        this.status = true;


        Date hora = new Date();
        horaInicio = hora.getTime();

        arena.setTipoCampo("0");
        arena.setPontoVida1(8000);
        arena.setPontoVida2(8000);


        // Sortear
        List<Long> moeda = new ArrayList<>();
        moeda.add(d1.getId());
        moeda.add(d2.getId());
        Collections.shuffle(moeda);
        long sorteado = (long) moeda.get(0);
        trocarturno(sorteado);

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
