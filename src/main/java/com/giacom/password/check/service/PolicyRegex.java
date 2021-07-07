package com.giacom.password.check.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.giacom.password.check.config.PasswordPolicyConfig;

@Component
public class PolicyRegex {

    private PasswordPolicyConfig config;

    public String getPolicyRegex(PasswordPolicyConfig policyConfig) {
        this.config = policyConfig;
        var regex = new StringBuilder("(");
        regex.append(minimumLowerCaseLetters())
                .append(minimumUpperCaseLetters())
                .append(minimumNumbers())
                .append(minimumSpecialCharacters())
                .append(".{")
                .append(config.getMinimumLength()).append(",")
                .append(config.getMaximumLength()).append("})");
        return regex.toString();
    }

    private String minimumSpecialCharacters() {
        var regex = new StringBuilder();
        if (config.getMinimumSpecialCharacters() > 0
                && (config.getAcceptedSpecialCharacters() != null
                && !config.getAcceptedSpecialCharacters().isEmpty())) {
            regex.append("(?=");
            regex.append(repeat(".*["
                            + config.getAcceptedSpecialCharacters() + "]",
                    config.getMinimumSpecialCharacters()));
            regex.append(")");
        }
        return regex.toString();
    }

    private String minimumNumbers() {
        var regex = new StringBuilder();
        if (config.getMinimumNumbers() > 0) {
            regex.append("(?=");
            regex.append(repeat(".*\\d", config.getMinimumNumbers()));
            regex.append(")");
        }
        return regex.toString();
    }

    private String minimumUpperCaseLetters() {
        var regex = new StringBuilder();
        if (config.getMinimumUpperCaseLetters() > 0) {
            regex.append("(?=");
            regex.append(repeat(".*[A-Z]", config.getMinimumUpperCaseLetters()));
            regex.append(")");
        }
        return regex.toString();
    }

    private String minimumLowerCaseLetters() {
        var regex = new StringBuilder();
        if (config.getMinimumLowerCaseLetters() > 0) {
            regex.append("(?=");
            regex.append(repeat(".*[a-z]", config.getMinimumLowerCaseLetters()));
            regex.append(")");
        }
        return regex.toString();
    }

    private String repeat(String text, int times) {
        return StringUtils.repeat(text, times);
    }

}
