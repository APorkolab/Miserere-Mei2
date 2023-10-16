package com.mrprokey.misereremei2.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatBotService {

    private final String OPENAI_URL = "https://api.openai.com/v1/engines/davinci/completions";
    private final String API_KEY = "YOUR_OPENAI_API_KEY";

    public String getGeneratedResponse(String prompt) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("prompt", prompt);
        requestBody.put("max_tokens", 150);

        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);

        ResponseEntity<String> response = restTemplate.postForEntity(OPENAI_URL, entity, String.class);
        JSONObject responseBody = new JSONObject(response.getBody());

        return responseBody.getString("choices").getJSONObject(0).getString("text").trim();
    }
}
