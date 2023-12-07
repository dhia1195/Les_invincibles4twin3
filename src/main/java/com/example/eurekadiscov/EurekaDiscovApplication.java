package com.example.eurekadiscov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer

@SpringBootApplication
public class EurekaDiscovApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaDiscovApplication.class, args);
    }

}
