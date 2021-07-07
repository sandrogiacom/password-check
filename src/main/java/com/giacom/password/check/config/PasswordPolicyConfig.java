package com.giacom.password.check.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "password.check")
public class PasswordPolicyConfig {

    private int minimumLength;
    private int maximumLength;
    private int minimumUpperCaseLetters;
    private int minimumLowerCaseLetters;
    private int minimumNumbers;
    private int minimumSpecialCharacters;
    private String acceptedSpecialCharacters;

    public int getMinimumLength() {
        return minimumLength;
    }

    public void setMinimumLength(int minimumLength) {
        this.minimumLength = minimumLength;
    }

    public int getMaximumLength() {
        return maximumLength;
    }

    public void setMaximumLength(int maximumLength) {
        this.maximumLength = maximumLength;
    }

    public int getMinimumUpperCaseLetters() {
        return minimumUpperCaseLetters;
    }

    public void setMinimumUpperCaseLetters(int minimumUpperCaseLetters) {
        this.minimumUpperCaseLetters = minimumUpperCaseLetters;
    }

    public int getMinimumLowerCaseLetters() {
        return minimumLowerCaseLetters;
    }

    public void setMinimumLowerCaseLetters(int minimumLowerCaseLetters) {
        this.minimumLowerCaseLetters = minimumLowerCaseLetters;
    }

    public int getMinimumNumbers() {
        return minimumNumbers;
    }

    public void setMinimumNumbers(int minimumNumbers) {
        this.minimumNumbers = minimumNumbers;
    }

    public int getMinimumSpecialCharacters() {
        return minimumSpecialCharacters;
    }

    public void setMinimumSpecialCharacters(int minimumSpecialCharacters) {
        this.minimumSpecialCharacters = minimumSpecialCharacters;
    }

    public String getAcceptedSpecialCharacters() {
        return acceptedSpecialCharacters;
    }

    public void setAcceptedSpecialCharacters(String acceptedSpecialCharacters) {
        this.acceptedSpecialCharacters = acceptedSpecialCharacters;
    }

}
