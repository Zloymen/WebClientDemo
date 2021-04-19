package com.moex.example.webclient.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
public class DemoWebClient {

    @Test
    void demoGet() {
        WebClient webClient = WebClient.create("https://api.github.com");

        String answer = webClient.get().uri("/organizations").retrieve().bodyToMono(String.class).block();

        log.info("answer: {}", answer);
    }
}
