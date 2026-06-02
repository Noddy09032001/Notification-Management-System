package com.example.noddy.notification_system.service.jwtService;

import com.example.noddy.notification_system.pojo.UserData;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

// this contains the code for jwt token generations, extracting informations and other stuff
/**
 * Handles all the JWT operations
 * responsible for - token generations, parsing, validations, claims extraction, validation and expiration checks, signing and verification
 */
@Service
public class JwtServiceImplementation {

    @Value("${jwt.secret}")
    private String secretKey;   // storing the secret key for the jwt token generation

    public String generateToken(UserData userData){
        Map<String, Object> claimsMap = new HashMap<>();

        // adding the roles inside the claims map
        claimsMap.put("roles", userData.getRoles().stream().map(role -> role.getRoleName()).toList());

        // adding the permissions to the claims map
        claimsMap.put("permissions", userData.getRoles().stream().flatMap(role -> role.getPermissions().stream())
                .map(permissionsData -> permissionsData.getPermissionName()).distinct().toList());

        return createToken(claimsMap, userData.getUsername());    // returning the token creation for the method
    }

    private String createToken(Map<String, Object> claimsMap, String userName){
        return Jwts.builder().setClaims(claimsMap)
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // getting the base64 encoded secret key for the token generation
    private Key getSignatureKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // getting the username from the token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // getting the user roles from the jwt token
    public List<String> extractRoles(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("roles", List.class);
    }

    // getting the user permissions from the jwt token
    public List<String> extractPermissions(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("permissions", List.class);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // generic claims function extractor
    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        final Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    // token validation
    public boolean isTokenValid(String token){
        return !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
