package com.giacom.password.check;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseIT {

    @LocalServerPort
    private int randomPort;
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @BeforeEach
    public void setUpApiAccess() {
        RestAssured.port = randomPort;
        RestAssured.basePath = contextPath;
    }

}
