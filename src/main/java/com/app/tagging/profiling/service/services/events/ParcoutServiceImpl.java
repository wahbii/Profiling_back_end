package com.app.tagging.profiling.service.services.events;

import com.app.tagging.profiling.dao.EventDao;
import com.app.tagging.profiling.dao.ParcoutDao;
import com.app.tagging.profiling.presentation.models.EventDescription;
import com.app.tagging.profiling.presentation.models.Parcourt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcoutServiceImpl implements  ParcoutService{


    @Autowired
    private ParcoutDao parcoutDao;

    @Autowired
    private EventDao eventDao;


    @Override
    public List<Parcourt> getEvents() {
        return parcoutDao.findAll();
    }

    @Override
    public Parcourt addPart(Parcourt parcourt) {
         Boolean isIn=parcoutDao.findAll().contains(parcourt);
         if(isIn){
             return  null;
         }else {
             return parcoutDao.save(parcourt);
         }


    }

    @Override
    public EventDescription addEventDescrition(Long parcourt, EventDescription eventDescription) {

        System.out.print("request id : "+parcourt);
        Parcourt parcourt1=parcoutDao.findById(parcourt).get();
        if(parcourt1!=null){
            for(EventDescription elm :parcourt1.getEventDescriptionList()){
                if(elm.compareTo(eventDescription)==1){
                    return  null;
                }
            }
            eventDescription.setParcourt(parcourt1);
            eventDao.save(eventDescription);
            return  eventDescription;
        }
        else {
            return  null;
        }

    }
}
