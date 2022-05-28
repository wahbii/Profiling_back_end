package com.app.tagging.profiling.utils;

import com.app.tagging.profiling.presentation.models.Source;

public class Utils {


    public static  String verifyIobject(Source source){
        if(source.getBase_url().isEmpty()){
            return  "get event from  \"firebase\"  ";
        }
        if ( source.getMethod().isEmpty()&&!source.getBase_url().isEmpty()){
            return  "no method added to acces to the base url";
        }
        return  "ok";



    }


}
