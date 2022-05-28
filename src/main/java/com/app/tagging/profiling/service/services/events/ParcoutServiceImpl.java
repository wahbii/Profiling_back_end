package com.app.tagging.profiling.service.services.events;

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


    @Override
    public List<Parcourt> getEvents() {
        return parcoutDao.findAll();
    }

    @Override
    public Parcourt addPart(Parcourt parcourt) {
        return parcoutDao.save(parcourt);
    }

    @Override
    public EventDescription addEventDescrition(Long parcourt, EventDescription eventDescription) {

        Parcourt parcourt1=parcoutDao.getById(parcourt);
        if(parcourt!=null){
            parcourt1.getEventDescriptionList().add(eventDescription);
            parcoutDao.save(parcourt1);
            return  eventDescription;
        }
        else {
            return  null;
        }

    }
}
