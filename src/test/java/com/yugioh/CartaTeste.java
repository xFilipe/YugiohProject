package com.yugioh;


import com.yugioh.model.Carta;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class CartaTeste {

    @Test
    public List<Carta> criarCarta(int c){

        List<Carta> cartas = new ArrayList<>();

        for(int i = 0; i < c; i++ ){
            Carta card = new Carta();
            card.setId((long) i);
            card.setNome("Nome " + i);
            card.setAtaque(100 + i);
            card.setDefesa(100 - i);
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

    @Test
    @Transactional
    public void salvarCarta(){
        Carta carta = criarCarta(1).get(0);
        System.out.println("Carta: " + carta);


        try {
            Carta.persist(carta);
            System.out.println("Carta salva: " + carta);

        }catch (Exception e){
            System.out.println("Não salvou : " + carta);
            e.printStackTrace();
        }

    }


}
