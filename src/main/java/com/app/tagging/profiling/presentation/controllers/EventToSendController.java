package com.app.tagging.profiling.presentation.controllers;

import com.app.tagging.profiling.presentation.models.EventDescription;
import com.app.tagging.profiling.presentation.models.EventToSend;
import com.app.tagging.profiling.presentation.models.Parcourt;
import com.app.tagging.profiling.service.services.eventToSend.EventToSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class EventToSendController {



    @Autowired
    private EventToSendService eventToSendService;



    @PostMapping(path = "/event/{parcout}")
    public ResponseEntity<Object>  postEvent(@PathVariable("parcout") long id,@RequestBody EventToSend eventToSend){

        EventDescription eventToSend1=eventToSendService.sendEvent(id,eventToSend);
        if(eventToSend1!=null){
            return  new ResponseEntity<>(eventToSend1, HttpStatus.OK);
        }else {
            HashMap<String,String> err=new HashMap<>();
            err.put("message","Probléme d'ajout d'évenement");
            return  new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
        }

    }

}
