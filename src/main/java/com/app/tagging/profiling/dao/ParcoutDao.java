package com.app.tagging.profiling.dao;

import com.app.tagging.profiling.presentation.models.Parcourt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcoutDao  extends JpaRepository<Parcourt,Long> {
}
