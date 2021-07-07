package com.giacom.password.check.api.v1.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.giacom.password.check.BaseIT;

public class ConfigurationControllerIT extends BaseIT {

    @Test
    @DisplayName("Settings are correctly configured")
    public void whenGetConfigurationsThenCheckResponseBody() {
        given()
                .when()
                .get("/api/v1/configurations")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("minimumLength", equalTo(9))
                .body("maximumLength", equalTo(50))
                .body("minimumUpperCaseLetters", equalTo(1))
                .body("minimumLowerCaseLetters", equalTo(1))
                .body("minimumNumbers", equalTo(1))
                .body("minimumSpecialCharacters", equalTo(1))
                .body("acceptedSpecialCharacters", equalTo("!@#$%^&*()-+"));
    }
}
