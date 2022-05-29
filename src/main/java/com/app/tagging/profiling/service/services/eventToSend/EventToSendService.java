package com.app.tagging.profiling.service.services.eventToSend;

import com.app.tagging.profiling.presentation.models.Application;
import com.app.tagging.profiling.presentation.models.EventDescription;
import com.app.tagging.profiling.presentation.models.EventToSend;

public interface EventToSendService {

    EventDescription sendEvent(long id, EventToSend eventToSend, Application application);

}
