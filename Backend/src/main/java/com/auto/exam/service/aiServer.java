package com.auto.exam.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClient;

import com.auto.exam.Dto.GeminiAnswer;
import com.auto.exam.Dto.GeminiModel;
import com.auto.exam.Dto.ModelListResponse;
import com.auto.exam.Dto.QuestionRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

@Service
public class aiServer {

    private static final Logger log = LoggerFactory.getLogger(aiServer.class);
    @Value("${spring.ai.openai.api-key}")
    private String GEMINI_API_KEY;
    private final RestClient restClient;

    public aiServer(RestClient.Builder builder) {
        log.info("GeminiModelController...");
        this.restClient = builder
                .baseUrl("https://generativelanguage.googleapis.com")
                .build();
    }

    public List<GeminiModel> models() {
        ResponseEntity<ModelListResponse> response = restClient.get()
                .uri("/v1beta/openai/models")
                .header("Authorization","Bearer " + GEMINI_API_KEY)
                .retrieve()
                .toEntity(ModelListResponse.class);
        return response.getBody().data();
    }

    @PostMapping("/answer")
    public GeminiAnswer askQuestion(@RequestBody QuestionRequest request) {

        String prompt = "Give simple questions with answers to following prompt(Question should give in json format)- " + request.getQuestion();
        String model = "models/gemini-2.0-flash"; // Or whichever model is appropriate
        String uri = "/v1beta/" + model + ":generateContent?key=" + GEMINI_API_KEY;

        // Build the request payload
        var payload = new java.util.HashMap<String, Object>();
        payload.put("contents", List.of(
                java.util.Map.of("parts", List.of(
                        java.util.Map.of("text", prompt)
                ))
        ));

        ResponseEntity<java.util.Map> response = restClient.post()
                .uri(uri)
                .body(payload)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});


        List<?> candidates = (List<?>) response.getBody().get("candidates");
        if (candidates != null && !candidates.isEmpty()) {
            var content = (java.util.Map<?, ?>) ((java.util.Map<?, ?>) candidates.get(0)).get("content");
            var parts = (List<?>) content.get("parts");
            var firstPart = (java.util.Map<?, ?>) parts.get(0);
            String text = (String) firstPart.get("text");
            return new GeminiAnswer(text);
        }

        return new GeminiAnswer("No response");
    }



}