package com.moex.example.webclient.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    @Qualifier("github")
    WebClient clientGitHub;


    @GetMapping("github/get")
    public String get() {
        return clientGitHub.get().uri("/organizations").retrieve().bodyToMono(String.class).block();
    }

}
