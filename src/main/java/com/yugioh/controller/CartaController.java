package com.yugioh.controller;


import com.yugioh.model.Carta;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("/card")
public class CartaController {


    @Produces(MediaType.TEXT_HTML)
    public String teste(){
        return "cadastrarCarta";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carta> list(){
        return Carta.listAll();
    }

    @POST
    @Transactional
    public List<Carta> create(List<Carta> cards){
        for(Carta card: cards){
            System.out.println("Objeto recebido " + card);
            try{
                card.persist();
                System.out.println("Objeto salvo " + card);

            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Valor nulo ou já existente no banco");
            }
        }

       return cards;
    }






}
