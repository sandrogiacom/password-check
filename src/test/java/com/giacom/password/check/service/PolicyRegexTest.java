package com.giacom.password.check.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.giacom.password.check.config.PasswordPolicyConfigBuilder;

class PolicyRegexTest {

    @Test
    @DisplayName("The minimum size must be 9")
    void whenGetPolicyRegexMinimumLengthThenCheckRegex() {
        var policyConfig = PasswordPolicyConfigBuilder.of()
                .minimumLength(9).build();
        var policyRegex = new PolicyRegex();
        var regex = policyRegex.getPolicyRegex(policyConfig);
        assertThat(regex).isEqualTo("(.{9,0})");
    }

    @Test
    @DisplayName("The maximum size must be 50")
    void whenGetPolicyRegexMaximumLengthThenCheckRegex() {
        var policyConfig = PasswordPolicyConfigBuilder.of()
                .maximumLength(50).build();
        var policyRegex = new PolicyRegex();
        var regex = policyRegex.getPolicyRegex(policyConfig);
        assertThat(regex).isEqualTo("(.{0,50})");
    }

    @Test
    @DisplayName("Must have at least one lowercase letter")
    void whenGetPolicyRegexMinimumLowerCaseLettersThenCheckRegex() {
        var policyConfig = PasswordPolicyConfigBuilder.of()
                .minimumLowerCaseLetters(1).build();
        var policyRegex = new PolicyRegex();
        var regex = policyRegex.getPolicyRegex(policyConfig);
        assertThat(regex).isEqualTo("((?=.*[a-z]).{0,0})");
    }

    @Test
    @DisplayName("Must have at least one uppercase letter")
    void whenGetPolicyRegexMinimumUpperCaseLettersThenCheckRegex() {
        var policyConfig = PasswordPolicyConfigBuilder.of()
                .minimumUpperCaseLetters(1).build();
        var policyRegex = new PolicyRegex();
        var regex = policyRegex.getPolicyRegex(policyConfig);
        assertThat(regex).isEqualTo("((?=.*[A-Z]).{0,0})");
    }

    @Test
    @DisplayName("Must have at least one number")
    void whenGetPolicyRegexMinimumNumbersThenCheckRegex() {
        var policyConfig = PasswordPolicyConfigBuilder.of()
                .minimumNumbers(1).build();
        var policyRegex = new PolicyRegex();
        var regex = policyRegex.getPolicyRegex(policyConfig);
        assertThat(regex).isEqualTo("((?=.*\\d).{0,0})");
    }

    @Test
    @DisplayName("Must have at least one special character")
    void whenGetPolicyRegexMinimumSpecialCharactersThenCheckRegex() {
        var policyConfig = PasswordPolicyConfigBuilder.of()
                .acceptedSpecialCharacters("#$%&@!")
                .minimumSpecialCharacters(1).build();
        var policyRegex = new PolicyRegex();
        var regex = policyRegex.getPolicyRegex(policyConfig);
        assertThat(regex).isEqualTo("((?=.*[#$%&@!]).{0,0})");
    }

    @Test
    @DisplayName("Must meet all rules")
    void whenGetPolicyRegexAllOptionsThenCheckRegex() {
        var policyConfig = PasswordPolicyConfigBuilder.of()
                .minimumLength(9)
                .maximumLength(99)
                .minimumUpperCaseLetters(1)
                .minimumLowerCaseLetters(1)
                .minimumNumbers(1)
                .minimumSpecialCharacters(1)
                .acceptedSpecialCharacters("!@#$%^&*()-+")
                .build();
        var policyRegex = new PolicyRegex();
        var regex = policyRegex.getPolicyRegex(policyConfig);
        assertThat(regex).isEqualTo("((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-+]).{9,99})");
    }
}
