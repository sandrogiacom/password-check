package com.giacom.password.check.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseIT {

    @LocalServerPort
    private int randomPort;
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Before
    public final void setUpApiAccess() {
        RestAssured.port = randomPort;
        RestAssured.basePath = contextPath;
    }

}
