package com.app.tagging.profiling.dao;

import com.app.tagging.profiling.presentation.models.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository  extends JpaRepository<Source,Long> {
}
