package com.yugioh;


import com.yugioh.model.Arena;
import com.yugioh.model.Deck;
import com.yugioh.model.Duelista;
import com.yugioh.model.Jogo;
import io.quarkus.test.junit.QuarkusTest;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class JogoTeste {

    Jogo jogo = new Jogo();
    Arena arena = new Arena();




    @Test
    public void preparar(){


        long id1 = 100l;
        long id2 = 200l;


        CartaTeste ct = new CartaTeste();

        Deck deck1 = new Deck();
        Deck deck2 = new Deck();


        Duelista d1 = new Duelista();
        Duelista d2 = new Duelista();

        // Mock

        List<Duelista> jodadores = new ArrayList<>();

        d1.setId(id1);
        d1.setNome("Nome 1");
        deck1.setDeckCartas(ct.criarCarta(39));
        deck1.setDeckPrincipal(true);
        deck1.embaralhar();
        d1.setDeckAtual(deck1);



        d2.setId(id2);
        d2.setNome("Nome 2");
        deck2.setDeckCartas(ct.criarCarta(39));
        deck2.setDeckPrincipal(true);
        deck2.embaralhar();
        d2.setDeckAtual(deck2);



        jodadores.add(d1);
        jodadores.add(d2);

        System.out.println(d1.getId());
        System.out.println(d1.getDeckAtual());
        System.out.println(d1.getNome());

        System.out.println(d2.getId());
        System.out.println(d2.getDeckAtual());
        System.out.println(d2.getNome());

        System.out.println("VAlor da lista: " + jodadores);
        init(d1, d2);

    }



    @Test
    public void init(@NotNull Duelista dx1, @NotNull Duelista dx2){
        System.out.println("-------------------------------------");

        System.out.println(dx1.getId());
        System.out.println(dx2.getId());
        System.out.println(dx1.getDeckAtual());
        System.out.println(dx2.getDeckAtual());
        System.out.println(jogo.comecar(dx1, dx2));
        System.out.println(jogo.getArena().getPontoVida1());
        System.out.println(jogo.getDuelista1());
        System.out.println(jogo.getHoraInicio());
        System.out.println("carta sacada: " + jogo.getDuelista1().getDeckAtual().sacar());
        System.out.println("Nome do duelista 2 " + jogo.getDuelista2().getNome());
        System.out.println("Jogador atual: " + jogo.getJogadorAtual().getNome());


        System.out.println("-------------------------------------");



    }



}
