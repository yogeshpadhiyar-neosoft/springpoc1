package com.neosoft.springPOC1.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtToken {

    private final String SECRET_KEY = "testing";

    /**
     * Generate JWT Token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails){
        Map<String , Object> claims = new HashMap<>();
        return createToken(claims , userDetails.getUsername());
    }

    /**
     * That private method call By generateToken
     * Using Username that method create new token with HS256 algorithm and Specific SECRET_KEY use in algorithm
     * @param claims
     * @param username
     * @return
     */
    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*24*60*60))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }

    /**
     * Use for get Username from specific JWT Token
     * @param token
     * @return
     */
    public String extractUserName(String token){
        return extractClaims(token , Claims :: getSubject);
    }

    /**
     * This method is Generic method for get anything from JWT Token
     * Need to pass token and claim Interface Function
     * That function apply on passing token
     * here use extractAllClaims method to get all claims into token
     * @param token
     * @param claimsFunction
     * @param <T>
     * @return
     */
    private <T> T extractClaims(String token, Function<Claims , T> claimsFunction) {
        Claims claims = extractAllClaims(token);
        return claimsFunction.apply(claims);
    }

    /**
     * Use to get all claims from JWT token
     * @param token
     * @return
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public Boolean validateToken(String token , UserDetails UserDetails){
        String username = extractUserName(token);
        return  (UserDetails.getUsername().equals(username) && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token , Claims::getExpiration);
    }
}

