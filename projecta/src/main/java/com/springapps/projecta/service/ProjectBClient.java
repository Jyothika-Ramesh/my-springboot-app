package com.springapps.projecta.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ProjectBClient {

    private final WebClient webClient;

    public ProjectBClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8081").build();
    }

    public String callProjectB() {
        String token = webClient.post()
                .uri("/auth/token")
                .body(BodyInserters.fromFormData("username", "projectA").with("password", "secret"))
                .retrieve()
                .bodyToMono(Map.class)
                .map(res -> res.get("token").toString())
                .block();

        return webClient.get()
                .uri("/api/secure/data")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

