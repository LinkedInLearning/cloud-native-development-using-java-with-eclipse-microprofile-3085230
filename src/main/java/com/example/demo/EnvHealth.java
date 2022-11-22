package com.example.demo;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Startup;

public class EnvHealth {

    public HealthCheckResponse call() {
        String customEnv = System.getenv("MY_CUSTOM_ENV");
        if (customEnv != null) {
            return HealthCheckResponse.named("EnvCheck")
                   .withData("present", true)
                   .up()
                   .build();
        } else {
            return HealthCheckResponse.named("EnvCheck")
                   .withData("present", false)
                   .down()
                   .build();
        }
    }
}