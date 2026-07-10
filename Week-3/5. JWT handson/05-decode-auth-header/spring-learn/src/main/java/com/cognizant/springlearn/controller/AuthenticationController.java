package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
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

        Map<String, String> response = new HashMap<>();
        response.put("token", "");

        LOGGER.info("authenticate() - END");
        return response;
    }

    private String getUser(String authHeader) {
        LOGGER.info("getUser() - START");
        LOGGER.debug("Header to decode: {}", authHeader);

        // Basic dXNlcjpkMjczMjFhOS0wNzUxLTRmNTktOGZjNi1mODYzMzg0N2E5Yjg=
        String encodedCredentials = authHeader.replace("Basic ", "");
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);

        // user:pwd
        String[] values = credentials.split(":", 2);
        String user = values[0];

        LOGGER.info("getUser() - END");
        return user;
    }
}
