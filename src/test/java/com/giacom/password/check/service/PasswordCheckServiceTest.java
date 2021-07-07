package com.giacom.password.check.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.giacom.password.check.config.PasswordPolicyConfig;
import com.giacom.password.check.config.PasswordPolicyConfigBuilder;

class PasswordCheckServiceTest {

    private PasswordPolicyConfig policyConfig = getDefaultPolicyConfig();
    private PolicyRegex policyRegex = new PolicyRegex(policyConfig);
    private PasswordCheckService passwordCheckService = new PasswordCheckService(
            policyRegex, policyConfig);

    @Test
    @DisplayName("Password valid returns true")
    void whenValidPasswordPatternThenReturnTrue() {
        var password = "Sandro@123";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("Password length minor than 9 returns false")
    void whenPasswordWithoutMinimumLengthThenReturnFalse() {
        var password = "Sandro@1";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password length bigger than 20 returns false")
    void whenPasswordBiggerMaximumLengthThenReturnFalse() {
        var password = "AbCdefghijklmnopqrs@123456";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with no one digit returns false")
    void whenPasswordWithoutDigitThenReturnFalse() {
        var password = "Sandro@xpte";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with no uppercase character returns false")
    void whenPasswordWithoutUppercaseThenReturnFalse() {
        var password = "sandro@1234";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with no lowercase character returns false")
    void whenPasswordWithoutLowercaseThenReturnFalse() {
        var password = "SANDRO@1234";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with no special character returns false")
    void whenPasswordWithoutSpecialCharThenReturnFalse() {
        var password = "SANDROx1234";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with middle space character returns false")
    void whenPasswordWithSpaceMiddleThenReturnFalse() {
        var password = "Sandro@ 1234";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with right space character returns false")
    void whenPasswordWithSpaceRightThenReturnFalse() {
        var password = "Sandro@1234 ";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with left space character returns false")
    void whenPasswordWithSpaceLeftThenReturnFalse() {
        var password = " Sandro@1234";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with blank character returns false")
    void whenPasswordIsBlankThenReturnFalse() {
        var password = "";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with blank space character returns false")
    void whenPasswordIsBlankSpaceThenReturnFalse() {
        var password = " ";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with null character returns false")
    void whenPasswordIsNullThenReturnFalse() {
        Boolean isValid = passwordCheckService.checkPassword(null);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Password with repeated character returns false")
    void whenPasswordWithRepeatedCharThenReturnFalse() {
        var password = "Saandro@1134";
        Boolean isValid = passwordCheckService.checkPassword(password);
        assertThat(isValid).isFalse();
    }

    private static PasswordPolicyConfig getDefaultPolicyConfig() {
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
