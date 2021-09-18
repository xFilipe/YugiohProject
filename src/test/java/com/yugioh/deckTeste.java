package com.yugioh;


import com.yugioh.model.Carta;
import com.yugioh.model.Deck;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class deckTeste {


    @Test
    public void criarDeck(){

        cartaTeste ct = new cartaTeste();
        //ct.criarCarta();

        Deck deck1 = new Deck();

        Carta card1 = new Carta();
        card1.setNome("Nome 1");
        card1.setAtaque(100);
        card1.setDefesa(100);
        card1.setDescricao("Teste");


        Carta card2 = new Carta();
        card2.setNome("Nome 2");
        card2.setAtaque(100);
        card2.setDefesa(100);
        card2.setDescricao("Teste");


        Carta card3 = new Carta();
        card3.setNome("Nome 3");
        card3.setAtaque(100);
        card3.setDefesa(100);
        card3.setDescricao("Teste");










    }






}
