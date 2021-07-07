package com.giacom.password.check.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.giacom.password.check.config.PasswordPolicyConfig;
import com.giacom.password.check.config.PasswordPolicyConfigBuilder;

class PasswordCheckServiceTest {

    private PasswordCheckService passwordCheckService;
    private PolicyRegex policyRegex = new PolicyRegex();

    @Test
    @DisplayName("Password valid returns true")
    void whenValidPasswordPatternThenReturnTrue() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = "Sandro@123";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("Password length minor than 9 returns false")
    void whenPasswordWithoutMinimumLengthThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = "Sandro@1";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password length bigger than 20 returns false")
    void whenPasswordBiggerMaximumLengthThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = "AbCdefghijklmnopqrs@123456";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with no one digit returns false")
    void whenPasswordWithoutDigitThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = "Sandro@xpte";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with no uppercase character returns false")
    void whenPasswordWithoutUppercaseThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = "sandro@1234";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with no lowercase character returns false")
    void whenPasswordWithoutLowercaseThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = "SANDRO@1234";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with no special character returns false")
    void whenPasswordWithoutSpecialCharThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = "SANDROx1234";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with middle space character returns false")
    void whenPasswordWithSpaceMiddleThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = "Sandro@ 1234";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with right space character returns false")
    void whenPasswordWithSpaceRightThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = "Sandro@1234 ";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with left space character returns false")
    void whenPasswordWithSpaceLeftThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = " Sandro@1234";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with blank character returns false")
    void whenPasswordIsBlankThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = "";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with blank space character returns false")
    void whenPasswordIsBlankSpaceThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = " ";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with null character returns false")
    void whenPasswordIsNullThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        Boolean isValid = passwordCheckService.checkPassword(null);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with repeated character returns false")
    void whenPasswordWithRepeatedCharThenReturnFalse() {
        var policyConfig = getDefaultPolicyConfig();
        passwordCheckService = new PasswordCheckService(policyRegex, policyConfig);
        var password = "Saandro@1134";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    private PasswordPolicyConfig getDefaultPolicyConfig() {
        return PasswordPolicyConfigBuilder.of()
                .minimumLength(9)
                .maximumLength(20)
                .minimumUpperCaseLetters(1)
                .minimumLowerCaseLetters(1)
                .minimumNumbers(1)
                .minimumSpecialCharacters(1)
                .acceptedSpecialCharacters("!@#$%^&*()-+")
                .build();
    }

}
