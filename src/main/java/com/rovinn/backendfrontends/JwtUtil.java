package com.rovinn.backendfrontends;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.awt.*;
import java.util.Date;

@Component
public class JwtUtil {
   private final String secret = "thisissecretkeyanduwillneverguessthis!2@#302#mfefejasmineeeeeeeeeeeeeeeeee";
   private SecretKey getSigningKey() {
      return Keys.hmacShaKeyFor(secret.getBytes());
   }
   public String generateToken(String email){
         return Jwts.builder().subject(email)
                 .issuedAt(new Date())
                 .expiration(new Date(System.currentTimeMillis()+1000*60*60*2)).signWith(getSigningKey()).compact();
   }
   public String extractEmail(String token){
       Claims claims = Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
       return claims.getSubject();
   }
}
