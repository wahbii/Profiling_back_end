package com.app.tagging.profiling.service.services.source;

import com.app.tagging.profiling.presentation.models.Source;

public interface SourceService {

    Source findById(long id);
    void save(Source source);
    void removeSource(long id);

    Source getSource();

}
