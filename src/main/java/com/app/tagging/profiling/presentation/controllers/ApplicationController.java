package com.app.tagging.profiling.presentation.controllers;

import com.app.tagging.profiling.dao.ApplicationDao;
import com.app.tagging.profiling.presentation.models.Application;
import com.app.tagging.profiling.utils.JwtToken;
import io.jsonwebtoken.JwtBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
   private ApplicationDao applicationDao;




   @PostMapping(path = "/")
   private ResponseEntity<Object> postApplication(@RequestBody Application application){
      for(Application app:applicationDao.findAll()){
          if(app.compareTo(this)==1){

             return  new ResponseEntity<>(JwtToken.GenerateToken(application.getId().toString()), HttpStatus.OK);


          }
      }

           applicationDao.save(application);
           return  new ResponseEntity<>(JwtToken.GenerateToken(application.getId().toString()), HttpStatus.OK);





   }


}
