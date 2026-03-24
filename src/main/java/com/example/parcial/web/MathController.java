package com.example.parcial.web;

import com.example.parcial.infraestructure.MathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/math")
public class MathController {
    private final MathService service;
    public MathController(MathService service) {
        this.service = service;
    }
    @GetMapping("/lucas")
    public ResponseEntity<Integer>getLucas(@PathVariable int value){
        return ResponseEntity.ok(service.calculateLucas(value));
    }

}
