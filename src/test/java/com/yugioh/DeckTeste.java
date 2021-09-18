package com.yugioh;


import com.yugioh.model.Carta;
import com.yugioh.model.Deck;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class DeckTeste {

    CartaTeste ct = new CartaTeste(); // Mock

    @Test
    public void criarDeck(){
        Deck deck1 = new Deck();
        deck1.setDeckCartas(ct.criarCarta(39));
        System.out.println(deck1.getDeckCartas());
    }

    @Test
    public void addCarta(){
        Deck deck2 = new Deck();
        Carta card = new Carta();
        card = ct.criarCarta(1).get(0);
        deck2.setDeckNome("Deck Teste");
        deck2.adicionarCarta(card);
        System.out.println(deck2);
    }

    @Test
    public void getCarta(){
        Deck deck3 = new Deck();
        deck3.setDeckCartas(ct.criarCarta(39));
        deck3.embaralhar();
        System.out.println("Carta sacada: " + deck3.sacar());
    }



}
