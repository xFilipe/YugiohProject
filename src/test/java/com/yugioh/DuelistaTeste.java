package com.yugioh;


import com.yugioh.model.Carta;
import com.yugioh.model.Deck;
import com.yugioh.model.Duelista;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class DuelistaTeste {

    Duelista duelista = new Duelista();
    DeckTeste deckTeste = new DeckTeste();
    CartaTeste ct = new CartaTeste();


    @Test
    public void sacarCarta(){
        ct.criarCarta(39);
        Deck deck = new Deck();
        System.out.println(deck);
        deck.setDeckCartas(ct.criarCarta(39));
        System.out.println(deck);
        System.out.println( "Carta sacada: "  + duelista.getMao().add(deck.sacar()));
        System.out.println("Mão: " + duelista.getMao());
        System.out.println(deck);
    }









}
