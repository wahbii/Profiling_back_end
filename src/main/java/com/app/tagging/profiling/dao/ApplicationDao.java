package com.app.tagging.profiling.dao;

import com.app.tagging.profiling.presentation.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationDao  extends JpaRepository<Application,Long> {
}
