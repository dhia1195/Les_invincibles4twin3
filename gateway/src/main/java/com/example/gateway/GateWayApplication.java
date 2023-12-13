package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("universite-s", r -> r.path("/universite/**")
                        .uri("http://universite:8070/"))
                .route("foyer-s", r -> r.path("/foyer/**")
                        .uri("http://foyer:8071/"))
                .route("reservation", r -> r.path("/reservationn/**")
                        .uri("http://reservation:8072/"))
                .route("etudiant-s", r -> r.path("/etudiant/**")
                        .uri("http://etudiant:8073/"))
                .route("bloc-s", r -> r.path("/Bloc/**")
                        .uri("http://bloc:8074/"))

                .build();
    }
}
