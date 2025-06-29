package com.Project2.BackEnd.Services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final Key key= Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPIRATION_TIME=1000*60*60*1;

    public String generateToken(String nic){
        return Jwts.builder()
                .setSubject(nic)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(key)
                .compact();

    }



}
