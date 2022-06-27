package com.example.limitsservice.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Limitation {

    @Value("${limits-service.minimum}")
    private String min;
    @Value("${limits-service.maximum}")
    private String  max;

    public Limitation() {
    }

    public Limitation(String min, String max) {
        this.min = min;
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public void setMax(String max) {
        this.max = max;
    }
}
