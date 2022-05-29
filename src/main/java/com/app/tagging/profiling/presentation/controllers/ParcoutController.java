package com.app.tagging.profiling.presentation.controllers;


import com.app.tagging.profiling.dao.ApplicationDao;
import com.app.tagging.profiling.presentation.models.Application;
import com.app.tagging.profiling.presentation.models.EventDescription;
import com.app.tagging.profiling.presentation.models.Parcourt;
import com.app.tagging.profiling.service.services.events.ParcoutService;
import com.app.tagging.profiling.utils.Exceptions.ParcoursExisteExeption;
import com.app.tagging.profiling.utils.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.events.Event;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class ParcoutController {

    @Autowired
    private ParcoutService parcoutService;

    @Autowired
    private ApplicationDao applicationDao;

    @GetMapping(path = "/parcout")
    public ResponseEntity<List<Parcourt>> getEvent(){
        List<Parcourt> parcourt=parcoutService.getEvents();
        if(parcourt!=null){
            return new ResponseEntity(parcourt, HttpStatus.OK);
        }else {
            return new ResponseEntity("null",HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(path = "/parcout")
    public ResponseEntity<Parcourt> addParcourt( @RequestHeader("Authorization") String token,@RequestBody  Parcourt parcourt) throws ParcoursExisteExeption {

        System.out.print("authorisation : "+token);
        System.out.print("data : "+ JwtToken.verifyToken(token));
        Long id_application=Long.parseLong(JwtToken.verifyToken(token));
        Application application=applicationDao.findById(id_application).get();
        if(application!=null){
            for (Parcourt elm:application.getParcourts()){
                if (elm.compareTo(parcourt)==1){
                    throw new ParcoursExisteExeption("this parcout already exist");

                }
            }
            parcourt.setApplication(application);
            application.getParcourts().add(parcourt);
            Parcourt parcourt1=parcoutService.addPart(parcourt);
            return new ResponseEntity<>(parcourt1,HttpStatus.OK);

        }else {
            throw new ParcoursExisteExeption("UnAuthorized");
        }

    }

    @PutMapping(path = "/parcout/{id_parcourt}")
    public ResponseEntity<EventDescription> addEvent(@PathVariable("id_parcourt") Long id,@RequestBody EventDescription eventDescription ) throws ParcoursExisteExeption {

        EventDescription parcourt=parcoutService.addEventDescrition(id,eventDescription);
        if(parcourt!=null){
            return new ResponseEntity<>(parcourt,HttpStatus.OK);
        }else {
            throw  new ParcoursExisteExeption("Event already exists");
        }

    }


}
