package com.yugioh;


import com.yugioh.model.Carta;
import com.yugioh.model.Deck;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class cartaTeste {

    @Test
    public List<Carta> criarCarta(int c){

        List<Carta> cartas = new ArrayList<>();

        for(int i = 0; i < c; i++ ){
            Carta card = new Carta();
            card.setNome("Nome " + i);
            card.setAtaque(100 + i);
            card.setAtaque(100 - i);
            card.setDescricao("Teste" + i);

            cartas.add(card);
        }
        return cartas;
    }

    @Test
    public void consultarCartas(){
        List<Carta> cartas = new ArrayList<>(criarCarta(3));
        for(Carta carta: cartas){
            System.out.println(carta.getNome());
        }
    }
}
