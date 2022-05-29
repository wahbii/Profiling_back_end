package com.app.tagging.profiling.presentation.controllers;

import com.app.tagging.profiling.dao.ApplicationDao;
import com.app.tagging.profiling.dao.ParcoutDao;
import com.app.tagging.profiling.presentation.models.Application;
import com.app.tagging.profiling.presentation.models.EventDescription;
import com.app.tagging.profiling.presentation.models.EventToSend;
import com.app.tagging.profiling.presentation.models.Parcourt;
import com.app.tagging.profiling.service.services.eventToSend.EventToSendService;
import com.app.tagging.profiling.service.services.events.ParcoutService;
import com.app.tagging.profiling.utils.Exceptions.NotAuthorized;
import com.app.tagging.profiling.utils.Exceptions.ParcoursExisteExeption;
import com.app.tagging.profiling.utils.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class EventToSendController {



    @Autowired
    private EventToSendService eventToSendService;

    @Autowired
    private ParcoutDao parcoutService;

    @Autowired
    private ApplicationDao applicationDao;



    @PostMapping(path = "/event/{parcout}")
    public ResponseEntity<Object>  postEvent(@RequestHeader("Authorization") String token, @PathVariable("parcout") long id, @RequestBody EventToSend eventToSend) throws NotAuthorized {
        try {
            Long id_application=Long.parseLong(JwtToken.verifyToken(token));
            Application application=applicationDao.findById(id_application).get();
            if(application!=null){

                EventDescription eventToSend1=eventToSendService.sendEvent(id,eventToSend,application);
                if(eventToSend1!=null){
                    return  new ResponseEntity<>(eventToSend1, HttpStatus.OK);
                }else {
                    HashMap<String,String> err=new HashMap<>();
                    err.put("message","Probléme d'ajout d'évenement");
                    return  new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
                }


            }else {
                throw new NotAuthorized("UnAuthorized");
            }
        }catch (Exception exception){
            throw new NotAuthorized("UnAuthorized");

        }



    }

}
