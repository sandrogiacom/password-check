package com.giacom.password.check.api.v1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giacom.password.check.service.PasswordCheckService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

@RestController("Password Check Controller")
@Api(tags = "Password Check")
@RequestMapping("/api/v1/passwords")
public class PasswordCheckController {

    private PasswordCheckService passwordCheckService;

    public PasswordCheckController(PasswordCheckService passwordCheckService) {
        this.passwordCheckService = passwordCheckService;
    }

    @PostMapping
    @Operation(summary = "Password Check ", description = "Checks if a password meets a certain definition")
    public ResponseEntity<Boolean> checkPassword(
            @Parameter(in = ParameterIn.DEFAULT, description = "Password to verify", required = true)
            @RequestBody String password) {
        return ResponseEntity.ok(passwordCheckService.checkPassword(password));
    }
}
