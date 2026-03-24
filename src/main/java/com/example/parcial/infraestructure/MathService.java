package com.example.parcial.infraestructure;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MathService {
    public List<Integer> getLucas (int value){
        List<Integer> chain = new ArrayList<>();
        for (int i = 0; i<=value; i++){
            chain.add(calculateLucas(i));
        }
        return chain;
    }

    public int calculateLucas (int value){
        if (value == 0){
            return 2;
        }else if (value == 1){
            return 1;
        }

        return calculateLucas(value -1) + calculateLucas(value -2);
    }
}
