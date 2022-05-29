package com.app.tagging.profiling.service.services.eventToSend;

import com.app.tagging.profiling.dao.EventDao;
import com.app.tagging.profiling.dao.EventToSendRepository;
import com.app.tagging.profiling.dao.ParcoutDao;
import com.app.tagging.profiling.presentation.models.Application;
import com.app.tagging.profiling.presentation.models.EventDescription;
import com.app.tagging.profiling.presentation.models.EventToSend;
import com.app.tagging.profiling.presentation.models.Parcourt;
import com.app.tagging.profiling.service.services.events.ParcoutService;
import com.app.tagging.profiling.service.services.source.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventToSendServiceImpl  implements  EventToSendService{


    @Autowired
    private ParcoutDao parcoutDao;


    @Autowired
    private EventDao eventdescDeo;


    @Autowired
    private EventToSendRepository eventToSendService;


    @Override
    public EventDescription sendEvent(long id, EventToSend eventToSend, Application application) {
        EventDescription  eventDescription=eventdescDeo.findById(id).get();

        if(eventDescription!=null&& application.getParcourts().contains(eventDescription.getParcourt())){
          eventDescription.getEventToSends().add(eventToSend);
          eventToSend.setEventDescription(eventDescription);
           eventToSend.setCode_event(eventDescription.getCode());

           if(!eventDescription.getElementToSend().isEmpty() &&eventDescription.getElementToSend().split(",").length==eventToSend.getElmSendList().split(",").length){
               eventToSend.setStatus("ok");
           }else {
               eventToSend.setStatus("manque de donnes");
           }

           eventdescDeo.save(eventDescription);


           return  eventDescription;
        }else{
            return null;
        }
    }
}
