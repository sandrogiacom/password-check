package com.giacom.password.check.api.v1.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.giacom.password.check.BaseIT;

public class PasswordCheckControllerIT extends BaseIT {

    @Test
    public void whenCheckValidPasswordThenReturnTrue() {
        given()
                .when()
                .body("Sandro@123")
                .post("/api/v1/passwords")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo("true"));
    }
}
