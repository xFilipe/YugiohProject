package com.yugioh;


import com.yugioh.model.Carta;
import com.yugioh.model.Deck;
import com.yugioh.model.Duelista;
import com.yugioh.model.Inventario;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class DuelistaTeste {

    Duelista duelista = new Duelista();
    DeckTeste deckTeste = new DeckTeste();
    CartaTeste ct = new CartaTeste();
    Inventario bag = new Inventario();



    @Test
    public void sacarCarta(){
        ct.criarCarta(39);
        Deck deck = new Deck();
        deck.setDeckCartas(ct.criarCarta(39));
        deck.setDeckNome("deck 1");
        System.out.println("Deck criado: " + deck);

        Deck deck2 = new Deck();
        deck2.setDeckCartas(ct.criarCarta(39));
        deck2.setDeckNome("deck 2");
        System.out.println("Deck criado: " + deck2);

        bag.getDecks().put("deck1",deck);
        bag.getDecks().put("deck2", deck2);
        System.out.println("Decks na mochila" + bag.getDecks());


        System.out.println( "Carta sacada: "  + duelista.getMao().add(bag.getDecks().get("deck1").sacar()));
        System.out.println("Mão: " + duelista.getMao());

    }









}
