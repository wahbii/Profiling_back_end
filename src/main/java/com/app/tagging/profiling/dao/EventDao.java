package com.app.tagging.profiling.dao;

import com.app.tagging.profiling.presentation.models.EventDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventDao extends JpaRepository<EventDescription,Long> {
}
