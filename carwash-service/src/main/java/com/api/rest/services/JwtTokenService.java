// package com.api.rest.services;
// 
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import java.util.Date;
// import org.springframework.stereotype.Service;
// 
// @Service
// public class JwtTokenService {
// 
//     private String jwtSecret = "yourSecretKey";  // Usa una clave secreta adecuada
//     private long jwtExpirationMs = 86400000; // Expiración del token (1 día)
// 
//     public String generateToken(String username) {
//         return Jwts.builder()
//                 .setSubject(username)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
//                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                 .compact();
//     }
// }
// 