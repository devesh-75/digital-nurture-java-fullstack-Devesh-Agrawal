package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("authenticate() - START");
        LOGGER.debug("Authorization header received: {}", authHeader);

        String user = getUser(authHeader);
        LOGGER.info("Decoded User: {}", user);

        String token = generateJwt(user);
        LOGGER.info("Generated Token: {}", token);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("authenticate() - END");
        return response;
    }

    private String getUser(String authHeader) {
        LOGGER.info("getUser() - START");
        LOGGER.debug("Header to decode: {}", authHeader);

        String encodedCredentials = authHeader.replace("Basic ", "");
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);

        String[] values = credentials.split(":", 2);
        String user = values[0];

        LOGGER.info("getUser() - END");
        return user;
    }

    private String generateJwt(String user) {
        LOGGER.info("generateJwt() - START for user: {}", user);

        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);

        // Set the token issue time as current time
        builder.setIssuedAt(new Date());

        // Set the token expiry as 20 minutes from now
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();

        LOGGER.info("generateJwt() - END");
        return token;
    }
}
