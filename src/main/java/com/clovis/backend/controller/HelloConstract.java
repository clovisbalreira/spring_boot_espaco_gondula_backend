package com.clovis.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConstract {
    @GetMapping("/")
    public ResponseEntity get(){
        return new ResponseEntity("Bem Vindo ao espaço de gondola", HttpStatus.ACCEPTED);
    }
}
