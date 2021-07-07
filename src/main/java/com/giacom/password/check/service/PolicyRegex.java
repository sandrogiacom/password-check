package com.giacom.password.check.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.giacom.password.check.config.PasswordPolicyConfig;

@Component
public class PolicyRegex {

    public String getPolicyRegex(PasswordPolicyConfig config) {
        StringBuilder regex = new StringBuilder("(");
        if (config.getMinimumLowerCaseLetters() > 0) {
            regex.append("(?=");
            regex.append(repeat(".*[a-z]", config.getMinimumLowerCaseLetters()));
            regex.append(")");
        }
        if (config.getMinimumUpperCaseLetters() > 0) {
            regex.append("(?=");
            regex.append(repeat(".*[A-Z]", config.getMinimumUpperCaseLetters()));
            regex.append(")");
        }
        if (config.getMinimumNumbers() > 0) {
            regex.append("(?=");
            regex.append(repeat(".*\\d", config.getMinimumNumbers()));
            regex.append(")");
        }
        if (config.getMinimumSpecialCharacters() > 0
                && (config.getAcceptedSpecialCharacters() != null
                && !config.getAcceptedSpecialCharacters().isEmpty())) {
            regex.append("(?=");
            regex.append(repeat(".*["
                            + config.getAcceptedSpecialCharacters() + "]",
                    config.getMinimumSpecialCharacters()));
            regex.append(")");
        }
        regex.append(".{");
        regex.append(config.getMinimumLength()).append(",");
        regex.append(config.getMaximumLength()).append("})");

        return regex.toString();
    }

    private String repeat(String text, int times) {
        return StringUtils.repeat(text, times);
    }

}
