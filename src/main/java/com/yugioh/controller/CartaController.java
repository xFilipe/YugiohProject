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
    public Carta create(Carta card){
        Date dt = new Date();
        card.setId(dt.getTime());
        System.out.println(card);
        try{
            card.persist();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Valor nulo ou já existente no banco");
        }
        return card;
    }






}
