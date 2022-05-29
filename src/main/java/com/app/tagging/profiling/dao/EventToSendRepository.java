package com.app.tagging.profiling.dao;

import com.app.tagging.profiling.presentation.models.EventToSend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventToSendRepository extends JpaRepository<EventToSend,Long> {
}
