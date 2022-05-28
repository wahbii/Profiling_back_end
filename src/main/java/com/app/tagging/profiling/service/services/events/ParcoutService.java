package com.app.tagging.profiling.service.services.events;

import com.app.tagging.profiling.presentation.models.EventDescription;
import com.app.tagging.profiling.presentation.models.Parcourt;

import java.util.List;

public interface ParcoutService {


    List<Parcourt> getEvents();
    Parcourt addPart(Parcourt parcourt);
    EventDescription  addEventDescrition(Long parcourt,EventDescription eventDescription);


}
