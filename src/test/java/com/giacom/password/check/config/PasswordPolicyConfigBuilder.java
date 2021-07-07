package com.giacom.password.check.config;

public final class PasswordPolicyConfigBuilder {
    private PasswordPolicyConfig passwordPolicyConfig;

    private PasswordPolicyConfigBuilder() {
        passwordPolicyConfig = new PasswordPolicyConfig();
    }

    public static PasswordPolicyConfigBuilder of() {
        return new PasswordPolicyConfigBuilder();
    }

    public PasswordPolicyConfigBuilder minimumLength(int minimumLength) {
        passwordPolicyConfig.setMinimumLength(minimumLength);
        return this;
    }

    public PasswordPolicyConfigBuilder maximumLength(int maximumLength) {
        passwordPolicyConfig.setMaximumLength(maximumLength);
        return this;
    }

    public PasswordPolicyConfigBuilder minimumUpperCaseLetters(int minimumUpperCaseLetters) {
        passwordPolicyConfig.setMinimumUpperCaseLetters(minimumUpperCaseLetters);
        return this;
    }

    public PasswordPolicyConfigBuilder minimumLowerCaseLetters(int minimumLowerCaseLetters) {
        passwordPolicyConfig.setMinimumLowerCaseLetters(minimumLowerCaseLetters);
        return this;
    }

    public PasswordPolicyConfigBuilder minimumNumbers(int minimumNumbers) {
        passwordPolicyConfig.setMinimumNumbers(minimumNumbers);
        return this;
    }

    public PasswordPolicyConfigBuilder minimumSpecialCharacters(int minimumSpecialCharacters) {
        passwordPolicyConfig.setMinimumSpecialCharacters(minimumSpecialCharacters);
        return this;
    }

    public PasswordPolicyConfigBuilder acceptedSpecialCharacters(String acceptedSpecialCharacters) {
        passwordPolicyConfig.setAcceptedSpecialCharacters(acceptedSpecialCharacters);
        return this;
    }

    public PasswordPolicyConfig build() {
        return passwordPolicyConfig;
    }
}
