package com.example.parcial.infraestructure;

import org.springframework.stereotype.Service;

@Service
public class MathService {
    public int calculateLucas (int value){
        if (value == 0){
            return 2;
        }else if (value == 1){
            return 1;
        }
        return calculateLucas(value -1) + calculateLucas(value -2);
    }
}
