package com.example.deliveryservice.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class HealthResource {
    private final Logger log = LoggerFactory.getLogger(HealthResource.class);

    @GetMapping(value = "/health", produces = "application/json")
    public ResponseEntity<Health> getHealth() {
        log.debug("REST REQUEST IS ACCEPTED, HEALTH 200 OK.");
        final var health = new Health();
        health.setHealthStatus(HealthStatus.UP);

        return ResponseEntity.ok().body(health);
    }
}
