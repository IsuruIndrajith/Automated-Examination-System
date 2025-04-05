// package com.auto.exam.service;

// import org.springframework.http.HttpHeaders;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import org.springframework.http.MediaType;

// import org.springframework.http.HttpEntity;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// @Service
// public class aiServer {

//     private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=YOUR_API_KEY"; // Use a specific model like gemini-pro
//     private final String API_KEY = "AIzaSyBcUsfH8V9z9ES0SVlYRAZAY_Lp2AdO800"; // Replace with your actual API key

//     public String getAIResponse(Map<String, Object> msg) {

//         String prompt = msg.get("prompt").toString();


//         RestTemplate restTemplate = new RestTemplate();

//         // Headers
//         HttpHeaders headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);
//         // The API key is passed as a query parameter in the URL, not as a Bearer token.
//         // headers.setBearerAuth(API_KEY);

//         // Body
//         Map<String, Object> body = new HashMap<>();
//         Map<String, Object> contents = new HashMap<>();
//         Map<String, Object> parts = new HashMap<>();
//         parts.put("text", prompt);
//         List<Map<String, Object>> partsList = new ArrayList<>();
//         partsList.add(parts);
//         contents.put("parts", partsList);
//         List<Map<String, Object>> contentsList = new ArrayList<>();
//         contentsList.add(contents);
//         body.put("contents", contentsList);

//         // Optional: Add generationConfig
//         Map<String, Object> generationConfig = new HashMap<>();
//         generationConfig.put("maxOutputTokens", 100);
//         body.put("generationConfig", generationConfig);

//         System.out.println("===================AI SERVER REQUEST===================");
//         System.out.println("Request Body: " + body.toString());
//         System.out.println("Request Headers: " + headers.toString());
//         System.out.println("=======================================================");

//         HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

//         // Send POST request
//         // The API key is already in the API_URL
//         ResponseEntity<Map> response = restTemplate.postForEntity(API_URL.replace("YOUR_API_KEY", API_KEY), request, Map.class);

//         // Extract the text response
//         if (response.getBody() != null && response.getBody().containsKey("candidates")) {
//             List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.getBody().get("candidates");
//             if (!candidates.isEmpty() && candidates.get(0).containsKey("content")) {
//                 Map<String, Object> content = (Map<String, Object>) candidates.get(0).get("content");
//                 if (content.containsKey("parts")) {
//                     List<Map<String, Object>> responseParts = (List<Map<String, Object>>) content.get("parts");
//                     if (!responseParts.isEmpty() && responseParts.get(0).containsKey("text")) {
//                         return (String) responseParts.get(0).get("text");
//                     }
//                 }
//             }
//         }

//         return null; // Or handle the error appropriately
//     }
// }