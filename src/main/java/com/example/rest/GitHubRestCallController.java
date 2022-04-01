package com.example.rest;

import com.example.bean.GitMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GitHubRestCallController {

    @Autowired
    RestTemplate restTemplate;

    static String URL="https://api.github.com/users/";

    @GetMapping("/github/{username}")
    public GitMapper restCall(@PathVariable String username) throws JsonProcessingException {
        System.out.println("Username passed is : "+username);
       String responseString = restTemplate.getForObject(URL+username,String.class);
       ObjectMapper objectMapper = new ObjectMapper();
       objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
       return objectMapper.readValue(responseString,GitMapper.class);
    }


}
