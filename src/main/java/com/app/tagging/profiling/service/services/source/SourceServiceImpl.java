package com.app.tagging.profiling.service.services.source;

import com.app.tagging.profiling.dao.SourceRepository;
import com.app.tagging.profiling.presentation.models.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SourceServiceImpl implements SourceService {


    @Autowired
    private SourceRepository sourceRepository;

    @Override
    public Source findById(long id) {
        return sourceRepository.findById(id).get();
    }

    @Override
    public void save(Source source) {
            sourceRepository.save(source);
    }

    @Override
    public void removeSource(long id) {
          sourceRepository.deleteById(id);
    }

    @Override
    public Source getSource() {
        try {
            Source source=sourceRepository.findAll().get(0);
            return  source;
        }catch (Exception e){
            return  null;
        }

    }
}
