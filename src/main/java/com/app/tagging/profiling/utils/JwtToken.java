package com.app.tagging.profiling.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtToken {

    private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256) ;



public static  String GenerateToken(String data){
    return  Jwts.builder().setSubject(Constante.CODE+"---"+data).signWith(key).compact();
}

public static String verifyToken(String jwt){

    String jwttoken= Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody().getSubject();

    return  jwttoken.replace(Constante.CODE+"---","").trim();


}



}
