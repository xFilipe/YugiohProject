package com.yugioh.controller;


import com.yugioh.model.Carta;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/card")
public class CartaController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carta> list(){
        return Carta.listAll();
    }


    @POST
    @Transactional
    public Carta create(Carta card){
        card.persist();
        return card;
    }


}
