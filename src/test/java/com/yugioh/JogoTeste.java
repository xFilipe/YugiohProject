package com.yugioh;


import com.yugioh.model.Arena;
import com.yugioh.model.Deck;
import com.yugioh.model.Duelista;
import com.yugioh.model.Jogo;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class JogoTeste {

    Jogo jogo = new Jogo();
    Arena arena = new Arena();


    Duelista d1 = new Duelista();
    Duelista d2 = new Duelista();

    CartaTeste ct = new CartaTeste();
    Deck deck1 = new Deck();
    Deck deck2 = new Deck();



    @Test
    public void preparar(){
        d1.setId(1l);
        d2.setId(21l);


        deck1.setDeckCartas(ct.criarCarta(39));
        d1.setDeckAtual(deck1);

        deck1.setDeckCartas(ct.criarCarta(39));
        d1.setDeckAtual(deck2);

    }



    @Test
    public void init(){
        System.out.println(jogo.comecar(d1, d2));


    }



}
