package com.giacom.password.check;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.giacom.password.check.config.PasswordPolicyConfig;

@SpringBootApplication
@EnableConfigurationProperties(PasswordPolicyConfig.class)
public class PasswordCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasswordCheckApplication.class, args);
    }

}
