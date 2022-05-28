package com.app.tagging.profiling.presentation.controllers;


import com.app.tagging.profiling.presentation.models.Source;
import com.app.tagging.profiling.service.services.source.SourceService;
import com.app.tagging.profiling.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SourceController {


    @Autowired
    private SourceService sourceService;



    @GetMapping("/source")
    public ResponseEntity<Source> getSource(){
        Source source=sourceService.getSource();
        if(source==null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(source,HttpStatus.OK);
        }


    }
    @PostMapping("/source")
    public ResponseEntity<String> postSource(@RequestBody Source source){
         String message= Utils.verifyIobject(source);
         System.out.print("request body :" +source);
         sourceService.save(source);
         return  new ResponseEntity<>(message,HttpStatus.OK);
    }
}
