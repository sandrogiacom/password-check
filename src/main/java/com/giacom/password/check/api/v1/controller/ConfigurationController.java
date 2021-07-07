package com.giacom.password.check.api.v1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giacom.password.check.config.PasswordPolicyConfig;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;

@RestController("Configuration Controller")
@Api(tags = "Configuration")
@RequestMapping("/api/v1/configurations")
public class ConfigurationController {

    private PasswordPolicyConfig config;

    public ConfigurationController(PasswordPolicyConfig config) {
        this.config = config;
    }

    @GetMapping
    @Operation(summary = "Configurations ", description = "List the settings for validating the password")
    public ResponseEntity<PasswordPolicyConfig> getConfigurations() {
        return ResponseEntity.ok(config);
    }

}
