package com.example.parcial.web;

import com.example.parcial.infraestructure.MathService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/math")
public class MathController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final MathService service;
    public MathController(MathService service) {
        this.service = service;
    }

    @GetMapping("/lucas")
    public List<Integer>getLucas(@RequestParam(value = "n", defaultValue = "0") int n){
        return service.getLucas(n);
    }
}
