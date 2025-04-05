package com.auto.exam.service;

import java.net.http.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.auto.exam.Dto.GenQuestion;

import org.springframework.web.client.RestTemplate;

@Service
public class ollamaService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String OLLAMA_URL = "http://127.0.0.1:11500/api/chat"; // use your port


    public String generateQuestions(Map<String, Object> payload) {        
        String userMessage = payload.get("prompt").toString();

        Map<String, Object> request = new HashMap<>();
        request.put("model", "deepseek-r1:1.5b"); // use your model name

        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(Map.of("role", "user", "content", userMessage));
        request.put("messages", messages);

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Make HTTP entity
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        System.out.println("Request to Ollama API:::::::::::::: " + entity.toString());
        // Send the POST request
        ResponseEntity<Map> response = restTemplate.postForEntity(OLLAMA_URL, entity, Map.class);

        System.out.println("Response from Ollama API:::::::::::::::::: " + response.toString());
        // Extract the content from the response
        Map message = (Map) response.getBody().get("message");
        if (message == null) {
            throw new RuntimeException("No message found in the response");
        }
        return (String) message.get("content");
    }
}
