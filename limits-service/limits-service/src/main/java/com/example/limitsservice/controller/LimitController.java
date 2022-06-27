package com.example.limitsservice.controller;


import com.example.limitsservice.model.Limitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    Limitation limitation;

    @GetMapping
    public Limitation getAll(){
        return limitation;
    }

}
