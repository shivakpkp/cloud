package com.example.netflixzuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication

@EnableDiscoveryClient
public class NetflixZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulServiceApplication.class, args);
	}

}
