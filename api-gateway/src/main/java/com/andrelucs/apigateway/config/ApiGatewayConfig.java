package com.andrelucs.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange/"))
                .route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion/"))
                // Shorter vertions
                .route(p -> p.path("/exchange/**").filters(f -> f.rewritePath("/exchange/(?<remaining>.*)", "/currency-exchange/${remaining}")).uri("lb://currency-exchange/"))
                .route(p -> p.path("/conversion/**").filters(f -> f.rewritePath("/conversion/(?<remaining>.*)", "/currency-conversion/${remaining}")).uri("lb://currency-conversion/"))
                .build();
    }

}
